package com.axonactive.devdayapp.dto;

import com.axonactive.devdayapp.enums.BookSource;

import io.swagger.annotations.ApiModelProperty;

public class SearchingCriteria {
    
    private String keyword;
    //this feature only in V2
    @ApiModelProperty(notes  = "Only used in V2")
    private BookSource bookSource;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

	public BookSource getBookSource() {
		return bookSource;
	}

	public void setBookSource(BookSource bookSource) {
		this.bookSource = bookSource;
	}
}

