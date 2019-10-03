package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.web.client.RestTemplate;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.BookDetailDto;
import com.axonactive.devdayapp.enums.BookSource;

public class PanMacService extends ExternalService {

    private static final String BASE_URL = "http://extracts.panmacmillan.com/getextracts?titlecontains=";

    @Override
    protected String buildQueryUrl(String keyword) {
        return BASE_URL + keyword;
    }

    @Override
    protected List<BookDto> extractBooks(JSONObject response) {
        List<BookDto> output = new LinkedList<>();
        JSONArray books = response.getJSONArray("Extracts");
        int len = books.length();
        for (int i = 0; i < len; ++i) {
            JSONObject book = books.getJSONObject(i);
            String name = book.getString("title");
            String author = book.getString("author");
            String cover = book.getString("jacketUrl");
            String preface = book.getString("extractHtml");

            BookDetailDto detail = new BookDetailDto();
            detail.setCoverUrl(cover);
            detail.setSource(BookSource.PANMAC);
            detail.setDescription(preface);
            List<BookDetailDto> details = new ArrayList<>(1);
            details.add(detail);

            BookDto bookDto = new BookDto();
            bookDto.setName(name);
            bookDto.setAuthor(author);
            bookDto.setDetails(details);

            output.add(bookDto);
        }
        return output;
    }

}

