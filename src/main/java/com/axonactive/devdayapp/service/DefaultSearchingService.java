package com.axonactive.devdayapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.SearchingCriteria;
import com.google.common.collect.ImmutableList;

@Component
public class DefaultSearchingService implements SearchingService {
    private static final Logger log = LogManager.getLogger(DefaultSearchingService.class);

    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    private static final ImmutableList<ExternalService> EXTERNAL_SERVICE = ImmutableList.of(
            new PanMacService(),
            new OpenLibraryService(),
            new BookMoochService(),
            new ITBookStoreService()
    );
    private static final Map<String, List<BookDto>> CACHED_RESULTS = new HashMap<>();
    private static final int ALLOWED_ENTRIES = 1000;

    @Autowired
    private BookService bookService;

    private String keyword;

    CompletableFuture<List<BookDto>> downloadExternal(ExternalService externalService, String keyWord) {
        return CompletableFuture.supplyAsync(() -> {
            String url = externalService.buildQueryUrl(keyWord);
            log.info("url: " + url);
            return url;
        }, EXECUTOR).thenApply(url -> {
            RestTemplate restTemplate = new RestTemplate();
            String rawResponse = restTemplate.getForObject(url, String.class);
            return rawResponse;
        }).thenApply(response -> {
            return externalService.extractBooks(response);
        });

    }


    CompletableFuture<List<BookDto>> downloadInternal(String keyWord)
    {
        return CompletableFuture.supplyAsync(() -> {
            InternalSearchRunner internal = new InternalSearchRunner(bookService, keyWord);
            return internal.call();
        }, EXECUTOR);
    };

    @Override
    public List<BookDto> search(SearchingCriteria criteria){
        String keyword = criteria.getKeyword();
        log.info("Search for books contain keyword: " + keyword);
        List<BookDto> cachedBooks = CACHED_RESULTS.get(keyword);
        if (cachedBooks != null) {
            log.info(cachedBooks.size() + " books loaded from cache's storage");
            return cachedBooks;
        }
        if (CACHED_RESULTS.size() > ALLOWED_ENTRIES) {
            CACHED_RESULTS.clear();
        }
        List<CompletableFuture<List<BookDto>>> pageContentFutures = EXTERNAL_SERVICE.stream()
                .map(externalService -> downloadExternal(externalService, keyword))
                .collect(Collectors.toList());

        pageContentFutures.add(downloadInternal(keyword));
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(pageContentFutures.toArray(new CompletableFuture[pageContentFutures.size()]));
        CompletableFuture<List<BookDto>> allPageContentsFuture = allFutures.thenApply(v -> {
            return pageContentFutures.stream()
                    .flatMap(pageContentFuture -> pageContentFuture.join().stream())
                    .collect(Collectors.toList());
         });

        List<BookDto> output;
        try
        {
            output = allPageContentsFuture.get();
            log.info("Total found {} books in our DB and external services", output.size());
            CACHED_RESULTS.put(keyword, output);
            return output;
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
