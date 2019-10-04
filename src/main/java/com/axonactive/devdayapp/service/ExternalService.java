package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.Collections;

import org.springframework.web.client.RestTemplate;

import com.axonactive.devdayapp.dto.BookDto;

public abstract class ExternalService {

    public List<BookDto> search(String keyword) {
        try {
            String url = buildQueryUrl(keyword);
            RestTemplate restTemplate = new RestTemplate();
            String rawResponse = restTemplate.getForObject(url, String.class);
            return extractBooks(rawResponse);
        } catch(Exception e) {
            //TODO: better exception handling please!
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    abstract protected String buildQueryUrl(String keyword);

    abstract protected List<BookDto> extractBooks(String response);

}

