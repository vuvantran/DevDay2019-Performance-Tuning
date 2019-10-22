package com.axonactive.devdayapp.service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.logger.Log;
import com.axonactive.devdayapp.util.Constants;

public abstract class ExternalService implements Callable<List<BookDto>> {
    private static @Log Logger log;

    private String keyword;

    protected ExternalService(String kw) {
        keyword = kw;
    }

    abstract protected ExternalService createSearchInstance(String kw);

    public List<BookDto> search(String keyword) {
        try {
            String url = buildQueryUrl(keyword);
            log.info("url: " + url);
            RestTemplate restTemplate = new RestTemplate();
            String rawResponse = restTemplate.getForObject(url, String.class);
            return extractBooks(rawResponse);
        } catch(Exception e) {
            log.error(Constants.ERROR_LOG_MSG, getServiceName(),
                "search", 
                String.format("keyword=%s, error=%s", keyword, e));
        }
        return Collections.emptyList();
    }

    abstract protected String buildQueryUrl(String keyword);

    abstract protected List<BookDto> extractBooks(String response);

    abstract protected String getServiceName();

    @Override
    public List<BookDto> call() {
        long startPot = System.currentTimeMillis();
        List<BookDto> output = search(keyword);
        System.out.println("-+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+-");
        System.out.println(">>> source: "+getServiceName()+" take: "+(System.currentTimeMillis() - startPot)+"ms");
        System.out.println("-+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+-");
        return output;
    }
}

