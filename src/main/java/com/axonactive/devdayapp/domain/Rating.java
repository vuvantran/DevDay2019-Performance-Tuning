package com.axonactive.devdayapp.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="book_ratings")
@Getter
@Setter
public class Rating implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="book_detail_id", nullable=false)
    private BookDetail bookDetail;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column
    private Integer value;


}

