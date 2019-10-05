package com.axonactive.devdayapp.service;

import java.util.List;
import java.util.concurrent.Callable;

import com.axonactive.devdayapp.dto.BookDto;

public class InternalSearchRunner implements Callable<List<BookDto>> {

    private BookService bookService;
    private String keyword;

    public InternalSearchRunner(BookService service, String kw) {
        bookService = service;
        keyword = kw;
    }

    @Override
    public List<BookDto> call() {
        long startPot = System.currentTimeMillis();
        List<BookDto> output = bookService.findBooksWithNameContain(keyword);
        System.out.println("-+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+-");
        System.out.println(">>> source: Internal take: "+(System.currentTimeMillis() - startPot)+"ms");
        System.out.println("-+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+-");
        return output;
    }
}

