package com.axonactive.devdayapp.dto;

import java.util.Arrays;
import java.util.List;

import org.checkerframework.checker.signedness.qual.Constant;

import com.axonactive.devdayapp.enums.BookSource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter	
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

	private Long id;
    private String name;
    private String author;
    private String serialNumber;
    private List<BookDetailDto> details;
    private List<UserDto> subscribers;
    
    public BookDto(String name, String author, String description, String coverUrl,BookSource source) {
    	this.name = name;
    	this.author = author;
    	BookDetailDto detail = new BookDetailDto();
    	detail.setCoverUrl(coverUrl);
    	detail.setDescription(description);
    	detail.setSource(source);
    	this.setDetails(Arrays.asList(detail));
    }
    /*public static SingleBookCreator createSingleBook() {
        return new SingleBookCreator();
    }
    public static class SingleBookCreator {

        private BookDto book = new BookDto();
        private BookDetailDto detail = new BookDetailDto();

        public SingleBookCreator withName(String name) {
            book.name = name;
            return this;
        }

        public SingleBookCreator withAuthor(String author) {
            book.author = author;
            return this;
        }

        public SingleBookCreator withDescription(String description) {
            detail.setDescription(description);
            return this;
        }

        public SingleBookCreator withCoverUrl(String coverUrl) {
            detail.setCoverUrl(coverUrl);
            return this;
        }

        public SingleBookCreator fromSource(BookSource source) {
            detail.setSource(source);
            return this;
        }

        public BookDto create() {
            book.setDetails(Arrays.asList(detail));
            return book;
        }
    }*/
}

