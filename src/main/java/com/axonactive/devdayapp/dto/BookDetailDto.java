package com.axonactive.devdayapp.dto;

import java.util.List;

import com.axonactive.devdayapp.domain.BookDetail;
import com.axonactive.devdayapp.domain.Comment;
import com.axonactive.devdayapp.domain.Rating;
import com.axonactive.devdayapp.domain.Tag;
import com.axonactive.devdayapp.enums.BookSource;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class BookDetailDto {
	private Long id;
	@JsonIgnore
    private BookDto book;
    private BookSource source;
    private String description;
    private List<CommentDto> comments;
    private List<RatingDto> ratings;
    private List<TagDto> tags;
    private String coverUrl;

    
    public BookDto getBook() {
        return book;
    }


}
