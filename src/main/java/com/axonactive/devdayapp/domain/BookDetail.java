package com.axonactive.devdayapp.domain;

import com.axonactive.devdayapp.enums.BookSource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="book_details")
@Getter
@Setter
public class BookDetail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    @Column
    private BookSource source;

   // @Transient
    @Column (length = 500)
    private String description;

    @Column(name="cover_url")
    private String coverUrl;

    @OneToMany(mappedBy="bookDetail")
    private List<Comment> comments;

    @OneToMany(mappedBy="bookDetail")
    private List<Rating> ratings;

    @OneToMany(mappedBy="bookDetail")
    private List<Tag> tags;


}
