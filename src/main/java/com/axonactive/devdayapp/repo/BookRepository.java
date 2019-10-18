package com.axonactive.devdayapp.repo;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.enums.BookSource;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    // Select part
    String SELECT_STATEMENT = "SELECT distinct(b.*) FROM Books b ";

    // Join part
    String BOOK_LEFT_JOIN_DETAILS = " full outer join Book_Details d on b.id = d.book_id ";
    String BOOK_LEFT_JOIN_TAGS = " full outer join Book_Tags t on d.id = t.book_detail_id ";
    String JOINS = BOOK_LEFT_JOIN_DETAILS + BOOK_LEFT_JOIN_TAGS;

    // Condition part
    String BOOK_CONDITION = " WHERE UPPER(b.name) LIKE UPPER(?1) OR UPPER(b.author) LIKE UPPER(?1) OR UPPER(b.serial_number) LIKE UPPER(?1) ";
    String BOOK_DETAILS_CONDITION = " OR UPPER(d.description) LIKE UPPER(?1)";
    String BOOK_TAGS_CONDITION = " OR UPPER(t.name) LIKE UPPER(?1)";
    String CONDITION = BOOK_CONDITION + BOOK_DETAILS_CONDITION + BOOK_TAGS_CONDITION;
    String BOOK_SOURCE_CONDITION = " WHERE (UPPER(b.name) LIKE UPPER(?1) OR UPPER(b.author) LIKE UPPER(?1) OR UPPER(b.serial_number) LIKE UPPER(?1))  AND d.source = ?2 ";

    String ORDER = " order by b.id";

    @Query(value = SELECT_STATEMENT + JOINS + CONDITION + ORDER, nativeQuery = true)
    List<Book> findBooksWithNameContain(String keyword);
    
    @Query(value = SELECT_STATEMENT + JOINS + BOOK_SOURCE_CONDITION + ORDER, nativeQuery = true)
    List<Book> findBooksWithNameAndSource(String keyword,int source);
}

