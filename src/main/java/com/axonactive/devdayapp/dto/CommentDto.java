package com.axonactive.devdayapp.dto;

public class CommentDto {
	private Long id;
    private BookDetailDto bookDetail;
    private UserDto user;
    private String content;
    private CommentDto parent;

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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentDto getParent() {
        return parent;
    }

    public void setParent(CommentDto parent) {
        this.parent = parent;
    }
}

