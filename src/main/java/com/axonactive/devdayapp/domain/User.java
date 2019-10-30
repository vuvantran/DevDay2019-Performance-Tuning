package com.axonactive.devdayapp.domain;

import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
    
    @Column
    private String fullName;

    @Column
    private String email;

    @Column
    private Date createAt = new Date();

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

   
}
