package com.axonactive.devdayapp.dto;

import java.util.List;

import com.axonactive.devdayapp.enums.BookSource;
import com.axonactive.devdayapp.domain.BookDetail;

public class BookDetailDto {
	private Long id;
    private BookDto book;
    private BookSource source;
    private String description;
    private List<CommentDto> comments;
    private List<RatingDto> ratings;
    private List<TagDto> tags;
    private String coverUrl;

    /**
     * This function just pull out basic information of the entity only
     * for others information, please do it yourself
     */
    public static BookDetailDto fromEntity(BookDetail entity) {
        BookDetailDto dto = new BookDetailDto();
        dto.id = entity.getId();
        dto.source = entity.getSource();
        dto.description = entity.getDescription();
        dto.coverUrl = entity.getCoverUrl();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }

    public BookSource getSource() {
        return source;
    }

    public void setSource(BookSource source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public List<RatingDto> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDto> ratings) {
        this.ratings = ratings;
    }

    public List<TagDto> getTags() {
        return tags;
    }

    public void setTags(List<TagDto> tags) {
        this.tags = tags;
    }
}
