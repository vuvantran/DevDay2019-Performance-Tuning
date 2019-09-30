package com.axonactive.devdayapp.repo;

import com.axonactive.devdayapp.domain.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
}

