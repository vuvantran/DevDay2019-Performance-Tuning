package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.Constants;
import com.axonactive.devdayapp.dto.BookDto;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

public abstract class ExternalService {
    private static final Logger log = LogManager.getLogger(ExternalService.class);

    //private String keyword;

    /*protected ExternalService(String kw) {
        keyword = kw;
    }*/

    //abstract protected ExternalService createSearchInstance(String kw);

    public List<BookDto> search(String keyword) {
        try {
            String url = buildQueryUrl(keyword);
            log.info("url: " + url);
            RestTemplate restTemplate = new RestTemplate();
            String rawResponse = restTemplate.getForObject(url, String.class);
            log.info("raw response: " + rawResponse);
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
}

