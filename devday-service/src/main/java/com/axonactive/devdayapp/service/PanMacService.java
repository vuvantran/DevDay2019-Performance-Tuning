package com.axonactive.devdayapp.service;

import java.util.LinkedList;
import java.util.List;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.enums.BookSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class PanMacService extends ExternalService {
    private static final Logger log = LogManager.getLogger(PanMacService.class);

    private static final String BASE_URL = "http://extracts.panmacmillan.com/getextracts?titlecontains=";

    @Override
    protected String buildQueryUrl(String keyword) {
        return BASE_URL + keyword;
    }

    @Override
    protected List<BookDto> extractBooks(String rawResponse) {
        JSONObject response = new JSONObject(rawResponse);
        List<BookDto> output = new LinkedList<>();
        JSONArray books = response.getJSONArray("Extracts");
        int len = books.length();
        log.info("Found " + len + " books from PanMac.");
        for (int i = 0; i < len; ++i) {
            JSONObject book = books.getJSONObject(i);
            String name = book.getString("title");
            String author = book.getString("author");
            String cover = book.getString("jacketUrl");
            String preface = book.getString("extractHtml");

            log.info(String.format(" Book %s, name=%s, author=%s", i+1, name, author));
            BookDto bookDto = BookDto.createSingleBook()
                .withName(name)
                .withAuthor(author)
                .withDescription(preface)
                .withCoverUrl(cover)
                .fromSource(BookSource.PANMAC)
                .create();

            output.add(bookDto);
        }
        return output;
    }

    @Override
    protected String getServiceName() {
        return "PanMac";
    }

}

