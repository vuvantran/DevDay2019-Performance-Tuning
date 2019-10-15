package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.LinkedList;

import org.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.BookDetailDto;
import com.axonactive.devdayapp.enums.BookSource;

public class BookMoochService extends ExternalService {
    private static final Logger log = LogManager.getLogger(BookMoochService.class);
    private static final String BASE_URL = "http://api.bookmooch.com/api/search?db=bm&o=json&txt=";

    public BookMoochService() {
        super("");
    }

    private BookMoochService(String kw) {
        super(kw);
    }

    @Override
    public ExternalService createSearchInstance(String kw) {
        return new BookMoochService(kw);
    }

    @Override
    protected String buildQueryUrl(String keyword) {
        return BASE_URL + keyword;
    }

    @Override
    protected List<BookDto> extractBooks(String rawResponse) {
        JSONArray response = new JSONArray(rawResponse);
        List<BookDto> output = new LinkedList<>();

        int len = response.length();
        log.info("Found " + len + " books from BookMooch.");
        for (int i = 0; i < len; ++i) {
            JSONObject book = response.getJSONObject(i);
            String author = "";
            try {
                author = book.getString("Author");
            } catch(JSONException ignored) {}
            String preface = "";
            try {
                preface = book.getString("EditorialReview_Content");
            } catch(JSONException ignored){}
            String coverUrl = "";
            try {
                coverUrl = book.getString("SmallImage_URL");
                coverUrl = book.getString("MediumImage_URL");
                coverUrl = book.getString("LargeImage_URL");
            } catch(JSONException ignored){}
            coverUrl = coverUrl.replaceAll("\\\\\\/", "/");
            String name = book.getString("Title");

            log.info(String.format(" Book %s, name=%s, author=%s", i+1, name, author));
            BookDto bookDto = BookDto.createSingleBook()
                .withName(name)
                .withAuthor(author)
                .withDescription(preface)
                .withCoverUrl(coverUrl)
                .fromSource(BookSource.BOOK_MOOCH)
                .create();
            output.add(bookDto);
        }
        return output;
    }

    @Override
    protected String getServiceName() {
        return "BookMooch";
    }
}

