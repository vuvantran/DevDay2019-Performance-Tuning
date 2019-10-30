package com.axonactive.devdayapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter	@Setter
public class RatingDto {
	private Long id;
	@JsonIgnore
    private BookDetailDto bookDetail;
    private UserDto user;
    private Integer value;
    }

