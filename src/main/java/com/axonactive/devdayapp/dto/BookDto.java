package com.axonactive.devdayapp.dto;

import java.util.List;

public class BookDto {

	private Long id;
    private String name;
    private String author;
    private String serialNumber;
    private List<BookDetailDto> details;
    private List<UserDto> subscribers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<BookDetailDto> getDetails() {
        return details;
    }

    public void setDetails(List<BookDetailDto> details) {
        this.details = details;
    }

    public List<UserDto> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<UserDto> subscribers) {
        this.subscribers = subscribers;
    }
}

