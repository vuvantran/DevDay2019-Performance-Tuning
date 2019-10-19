package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.Constants;
import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.SearchingCriteria;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public List<BookDto> search(SearchingCriteria criteria) {
        long startTime = System.currentTimeMillis();
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
        List<BookDto> output = new LinkedList<>();
        Future<List<BookDto>>[] resultCacher = new Future[EXTERNAL_SERVICE.size() + 1];
        resultCacher[0] = EXECUTOR.submit(new InternalSearchRunner(bookService, keyword));
        int i = 1;
        for (ExternalService exService: EXTERNAL_SERVICE) {
            ExternalService searchInstance = exService.createSearchInstance(keyword);
            resultCacher[i] = EXECUTOR.submit( searchInstance );
            ++i;
        }
        for (i = 0; i < resultCacher.length; ++i) {
            try {
                List<BookDto> resultOfSearch = resultCacher[i].get();
                output.addAll(resultOfSearch);
            } catch(InterruptedException | ExecutionException ignored) {}
        }
        log.info("Total found {} books in our DB and external services", output.size());
        log.info(Constants.INFO_LOG_MSG, getClass(),
                "search", 
                System.currentTimeMillis() - startTime,
                String.format("keyword=%s", keyword));
        CACHED_RESULTS.put(keyword, output);
        return output;
    }
}

