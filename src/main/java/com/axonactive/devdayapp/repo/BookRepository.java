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


    // Select part
    String SELECT_STATEMENT = "SELECT distinct(b.*) FROM Books b ";

    // Join part
    String BOOK_LEFT_JOIN_DETAILS = " left join Book_Details d on b.id = d.book_id ";
    String BOOK_LEFT_JOIN_TAGS = " left join Book_Tags t on d.id = t.book_detail_id ";
    String JOINS = BOOK_LEFT_JOIN_DETAILS + BOOK_LEFT_JOIN_TAGS;

    // Condition part
    String BOOK_CONDITION = " WHERE UPPER(b.name) LIKE UPPER(?1) OR UPPER(b.author) LIKE UPPER(?1) OR UPPER(b.serial_number) LIKE UPPER(?1) ";
    String BOOK_DETAILS_CONDITION = " OR UPPER(d.description) LIKE UPPER(?1)";
    String BOOK_TAGS_CONDITION = " OR UPPER(t.name) LIKE UPPER(?1)";
    String CONDITION = BOOK_CONDITION + BOOK_DETAILS_CONDITION + BOOK_TAGS_CONDITION;

    String ORDER = " order by b.id";

    @Query(value = SELECT_STATEMENT + JOINS + CONDITION + ORDER, nativeQuery = true)
    List<Book> findBooksWithNameContain(String keyword);
}

