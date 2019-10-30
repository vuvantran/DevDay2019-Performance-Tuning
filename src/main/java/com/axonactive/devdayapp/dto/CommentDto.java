package com.axonactive.devdayapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter	
@Setter
public class CommentDto {
	private Long id;
	 @JsonIgnore 
    private BookDetailDto bookDetail;
    private UserDto user;
    private String content;
    @JsonIgnore 
    private CommentDto parent;

    private Long parentId;

}

