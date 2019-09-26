package com.axonactive.devdayapp.domain;

import com.axonactive.devdayapp.enums.BookSource;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="book_details")
public class BookDetail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    @Column
    private BookSource source;

    @Column
    private String description;

    @OneToMany(mappedBy="bookDetail")
    List<Comment> comments;

    @OneToMany(mappedBy="bookDetail")
    List<Rating> ratings;

    @OneToMany(mappedBy="bookDetail")
    List<Tag> tags;

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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
