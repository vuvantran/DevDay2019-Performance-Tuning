package com.axonactive.devdayapp.repo;

import java.util.List;

import com.axonactive.devdayapp.domain.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE UPPER(b.name) LIKE CONCAT('%', UPPER(?1), '%')")
    List<Book> findBooksWithNameContain(String keyword);
    
    @Query ("SELECT b FROM Book b WHERE b.id = ?1")
    Book getBookById(long id);
}

