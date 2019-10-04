package com.axonactive.devdayapp.service;

import java.util.LinkedList;
import java.util.List;

import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.enums.BookSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenLibraryService extends ExternalService {
    private static final Logger log = LogManager.getLogger(OpenLibraryService.class);

    private static final String BASE_URL = "http://openlibrary.org/search.json?title=";
    private static final String COVER_URL = "https://covers.openlibrary.org/w/id/{cid}-L.jpg";

    @Override
    protected String buildQueryUrl(String keyword) {
        return BASE_URL + keyword;
    }

    @Override
    protected List<BookDto> extractBooks(JSONObject response) {
        List<BookDto> books = new LinkedList<>();
        JSONArray docs = response.getJSONArray("docs");
        int len = docs.length();
        log.info("Found " + len + " books from OpenLibrary.");
        for (int i = 0; i < len; ++i) {
            JSONObject doc = docs.getJSONObject(i);
            String coverId = "";
            try {
                coverId += doc.getLong("cover_i");
            } catch(JSONException ignored) {}
            String coverUrl = "";
            if ( ! coverId.isEmpty()) {
                coverUrl = COVER_URL.replace("{cid}", coverId);
            }
            String name = doc.getString("title");
            
            JSONArray authors = null;
            try {
                authors = doc.getJSONArray("author_name");
            } catch(JSONException ignored) { }
            StringBuilder author = new StringBuilder();
            int jlen = 0;
            if (authors != null) {
                jlen = authors.length();
                if (jlen > 0)
                    author.append( authors.getString(0) );
                for (int j = 1; j < jlen; ++j) {
                    String authorName = authors.getString(j);
                    author.append(authorName).append("; ");
                }
            }
            JSONArray sentence = null;
            try {
                sentence = doc.getJSONArray("first_sentence");
            } catch(JSONException ignored) {}
            StringBuilder preface = new StringBuilder();
            if (sentence != null) {
                jlen = sentence.length();
                for (int j = 0; j < jlen; ++j) {
                    String s = sentence.getString(j);
                    preface.append(s).append("<br/>");
                }
            }

            log.info(String.format(" Book %s, name=%s, author=%s", i+1, name, author));
            BookDto book = BookDto.createSingleBook()
                .withName(name)
                .withAuthor(author.toString())
                .withDescription(preface.toString())
                .withCoverUrl(coverUrl)
                .fromSource(BookSource.OPEN_LIBRARY)
                .create();

            books.add(book);
        }
        return books;
    }

    @Override
    protected String getServiceName() {
        return "OpenLibrary";
    }

}

