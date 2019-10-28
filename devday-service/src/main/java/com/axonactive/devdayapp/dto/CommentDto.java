package com.axonactive.devdayapp.dto;

import com.axonactive.devdayapp.domain.Comment;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CommentDto {
	private Long id;
    private BookDetailDto bookDetail;
    private UserDto user;
    private String content;
    @JsonIgnore 
    private CommentDto parent;
    private long bookDetailId;

    private Long parentId;

    public CommentDto() {
    }

    public CommentDto(Long id, String content, long bookDetailId) {
        this.id = id;
        this.content = content;
        this.bookDetailId = bookDetailId;
    }

    public static CommentDto fromEntity(Comment entity) {
        if (entity == null) return null;
        CommentDto dto = new CommentDto();
        dto.id = entity.getId();
        dto.user = UserDto.fromEntity(entity.getUser());
        dto.content = entity.getContent();
        dto.parent = CommentDto.fromEntity(entity.getParent());
        return dto;
    }

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

    public long getBookDetailId() {
        return bookDetailId;
    }

    public void setBookDetailId(long bookDetailId) {
        this.bookDetailId = bookDetailId;
    }
}

