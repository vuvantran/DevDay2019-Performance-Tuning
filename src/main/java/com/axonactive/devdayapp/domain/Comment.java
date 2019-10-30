package com.axonactive.devdayapp.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="book_comments")
@Getter
@Setter
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="book_detail_id", nullable=false)
    private BookDetail bookDetail;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=true)
    private User user;

    @Column (length = 500)
    private String content;
    @ManyToOne
    @JoinColumn (name="parent_id" , nullable=true)
    private Comment parent;


}

