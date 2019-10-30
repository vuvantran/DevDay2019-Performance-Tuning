package com.axonactive.devdayapp.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="book_tags")
@Getter
@Setter
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name="book_detail_id", nullable=false)
    private BookDetail bookDetail;

    @Column
    private String name;

}

