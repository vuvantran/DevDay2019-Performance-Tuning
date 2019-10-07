package com.axonactive.devdayapp.repo;

import com.axonactive.devdayapp.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

//    String BOOK_SELECT_STATEMENT = "SELECT b.* FROM Books b, Book_Details d, Book_Tags t WHERE ";
//    String BOOK_JOIN_CONDITION = " b.id = d.book_id AND d.id = t.book_detail_id AND ";
//    String BOOK_CONDITION = "UPPER(b.name) LIKE UPPER(?1) OR UPPER(b.author) LIKE UPPER(?1) OR UPPER(b.serial_number) LIKE UPPER(?1) OR UPPER(d.description) LIKE UPPER(?1)";
//
//    @Query(value = BOOK_SELECT_STATEMENT + BOOK_JOIN_CONDITION + BOOK_CONDITION, nativeQuery = true)
//    List<Book> findBooksWithNameContain(String keyword);


    String BOOK_SELECT_STATEMENT = "SELECT distinct(b.*) FROM Books b left join Book_Details d on b.id = d.book_id  WHERE ";
    String BOOK_CONDITION = "UPPER(b.name) LIKE UPPER(?1) OR UPPER(b.author) LIKE UPPER(?1) OR UPPER(b.serial_number) LIKE UPPER(?1) OR UPPER(d.description) LIKE UPPER(?1)";

    @Query(value = BOOK_SELECT_STATEMENT + BOOK_CONDITION, nativeQuery = true)
    List<Book> findBooksWithNameContain(String keyword);
}

