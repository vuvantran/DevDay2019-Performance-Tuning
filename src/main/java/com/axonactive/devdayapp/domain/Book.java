package com.axonactive.devdayapp.domain;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private String serialNumber;

    @OneToMany(mappedBy="book")
    private List<BookDetail> details;

    @ManyToMany(mappedBy="bookInWishList")
    private List<User> subscribers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<BookDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BookDetail> details) {
        this.details = details;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

}

