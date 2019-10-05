package com.axonactive.devdayapp.service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.service.BookService;
import com.axonactive.devdayapp.service.ExternalService;
import com.axonactive.devdayapp.service.PanMacService;
import com.axonactive.devdayapp.service.OpenLibraryService;
import com.axonactive.devdayapp.service.BookMoochService;
import com.axonactive.devdayapp.service.ITBookStoreService;
import com.axonactive.devdayapp.service.InternalSearchRunner;
import com.axonactive.devdayapp.dto.SearchingCriteria;

import com.google.common.collect.ImmutableList;
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
    
    @Autowired
    private BookService bookService;

    public List<BookDto> search(SearchingCriteria criteria) {
        String keyword = criteria.getKeyword();
        log.info("Search for books contain keyword: " + keyword);
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
        return output;
    }
}

