package com.axonactive.devdayapp.domain;

import com.axonactive.devdayapp.enums.BookSource;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class BookDetail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @Column
    private Book book;

    @Column
    private BookSource source;

    @Column
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBookId(Book book) {
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
}
