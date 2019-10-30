package com.axonactive.devdayapp.domain;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="books")
@Getter
@Setter
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @Column (length = 500)
    private String name;

    @Column (length = 500)
    private String author;

    @Column (name = "serial_number")
    private String serialNumber;

    
    @OneToMany(mappedBy="book",fetch =  FetchType.LAZY)
    private List<BookDetail> details;
    
    
    @ManyToMany(mappedBy="bookInWishList")
    private List<User> subscribers;



}

