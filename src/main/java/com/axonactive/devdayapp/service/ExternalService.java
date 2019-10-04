package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.axonactive.devdayapp.dto.BookDto;

public abstract class ExternalService {
    private static final Logger log = LogManager.getLogger(ExternalService.class);

    public List<BookDto> search(String keyword) {
        try {
            String url = buildQueryUrl(keyword);
            log.info("url: " + url);
            RestTemplate restTemplate = new RestTemplate();
            String rawResponse = restTemplate.getForObject(url, String.class);
            log.info("raw response: " + rawResponse);
            return extractBooks(rawResponse);
        } catch(Exception e) {
            log.error("Error occurred while connecting to " + getServiceName() + ": " + e);
        }
        return Collections.emptyList();
    }

    abstract protected String buildQueryUrl(String keyword);

    abstract protected List<BookDto> extractBooks(String response);

    abstract protected String getServiceName();
}

