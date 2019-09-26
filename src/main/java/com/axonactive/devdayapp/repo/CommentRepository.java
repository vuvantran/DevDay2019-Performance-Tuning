package com.axonactive.devdayapp.repo;

import com.axonactive.devdayapp.domain.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {}

