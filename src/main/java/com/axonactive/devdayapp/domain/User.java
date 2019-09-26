package com.axonactive.devdayapp.domain;

import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @Column
    private String fullName;

    @Column
    private String email;

    @Column
    private Date createAt;

    @OneToMany(mappedBy="user")
    private List<Comment> comments;

    @OneToMany(mappedBy="user")
    private List<Device> devices;

    @OneToMany(mappedBy="user")
    private List<Rating> ratings;

    @ManyToMany
    @JoinTable(
        name = "user_books",
        joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    private List<Book> bookInWishList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Book> getBookInWishList() {
        return bookInWishList;
    }

    public void setBookInWishList(List<Book> bookInWishList) {
        this.bookInWishList = bookInWishList;
    }
}
