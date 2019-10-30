package com.axonactive.devdayapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter	
@Setter
public class TagDto {

	private Long id;
	//@Getter(AccessLevel.NONE)
	@JsonIgnore
    private BookDetailDto bookDetail;
    private String name;

    
    public BookDetailDto getBookDetail() {
        return bookDetail;
    }

}

