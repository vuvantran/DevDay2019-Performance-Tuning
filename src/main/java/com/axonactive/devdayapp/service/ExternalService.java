package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.Collections;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.axonactive.devdayapp.dto.BookDto;

public abstract class ExternalService {

    public List<BookDto> search(String keyword) {
        try {
            String url = buildQueryUrl(keyword);
            RestTemplate restTemplate = new RestTemplate();
            String rawResponse = restTemplate.getForObject(url, String.class);
            JSONObject jsonResponse = new JSONObject(rawResponse);
            return extractBooks(jsonResponse);
        } catch(Exception e) {
            // better handle for exception please
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    abstract protected String buildQueryUrl(String keyword);

    abstract protected List<BookDto> extractBooks(JSONObject jsonResponse);

}

