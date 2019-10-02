package com.axonactive.devdayapp.dto;

public class TagDto {
	private Long id;
    private BookDetailDto bookDetail;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookDetailDto getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetailDto bookDetail) {
        this.bookDetail = bookDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

