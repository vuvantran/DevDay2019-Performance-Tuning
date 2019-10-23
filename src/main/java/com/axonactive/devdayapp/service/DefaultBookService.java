package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.domain.BookDetail;
import com.axonactive.devdayapp.domain.Comment;
import com.axonactive.devdayapp.domain.Rating;
import com.axonactive.devdayapp.domain.Tag;
import com.axonactive.devdayapp.dto.BookDetailDto;
import com.axonactive.devdayapp.dto.BookDto;
import com.axonactive.devdayapp.dto.CommentDto;
import com.axonactive.devdayapp.dto.RatingDto;
import com.axonactive.devdayapp.dto.TagDto;
import com.axonactive.devdayapp.repo.BookDetailRepository;
import com.axonactive.devdayapp.repo.BookRepository;
import com.axonactive.devdayapp.util.BookUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.axonactive.devdayapp.Constants;
import com.axonactive.devdayapp.logger.Log;


@Service
public class DefaultBookService implements BookService {
    private static @Log Logger log;
    
    @Autowired
    private BookRepository bookRepo;

	@Autowired
	private BookDetailRepository bookDetailRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public BookDto findById(long bookId) {
        long startTime = System.currentTimeMillis();
		Optional<Book> result = bookRepo.findById(bookId);
        log.info(Constants.INFO_LOG_MSG, getClass().getName(),
                "findById", 
                System.currentTimeMillis() - startTime,
                String.format("bookId=%s", bookId));
		if(result.isPresent())
			return BookUtil.toFullBookDto(result.get());
		else
			return null;
	}

	@Override
	public List<BookDto> getAll() {
        long startTime = System.currentTimeMillis();
		List<BookDto> books = StreamSupport.stream(bookRepo.findAll().spliterator(),false)
			.map(book -> BookUtil.toSimpleBookDto(book))
            .collect(Collectors.toList());
        log.info(Constants.INFO_LOG_MSG, getClass().getName(),
                "getAll", 
                System.currentTimeMillis() - startTime,
                "");
        return books;
	}

	@Override
	@Transactional
	public List<BookDto> findBooksWithNameContain(String keyword) {
		long startTime = System.currentTimeMillis();
		List<BookDto> books = new LinkedList<>();
		List<Book> bookList = bookRepo.findBooksWithNameContain("%".concat(keyword).concat("%"));
		List<BookDetailDto> bookDetailList = findAllBookDetails(bookList.stream().map(Book::getId).collect(Collectors.toList()));
		List<CommentDto> commentDtoList = findAllBookComments(bookDetailList.stream().map(BookDetailDto::getId).collect(Collectors.toList()));
		List<RatingDto> ratingDtoList = findAllBookRatings(bookDetailList.stream().map(BookDetailDto::getId).collect(Collectors.toList()));
		List<TagDto> tagDtoList = findAllBookTags(bookDetailList.stream().map(BookDetailDto::getId).collect(Collectors.toList()));

		for (Book book : bookList) {
			BookDto bookDto = BookDto.fromEntity(book);
			List<BookDetailDto> detailDtos = new LinkedList<>();
			bookDetailList.stream().filter(f -> f.getBookId() == book.getId()).forEach(d -> {
				d.setComments(commentDtoList.stream().filter(f -> f.getBookDetailId() == d.getId()).collect(Collectors.toList()));
				d.setRatings(ratingDtoList.stream().filter(f -> f.getBookDetailId() == d.getId()).collect(Collectors.toList()));
				d.setTags(tagDtoList.stream().filter(f -> f.getBookDetailId() == d.getId()).collect(Collectors.toList()));
				detailDtos.add(d);
			});

			bookDto.setDetails(detailDtos);
			books.add(bookDto);
		}
		log.info(Constants.INFO_LOG_MSG, getClass().getName(),
				"findBooksWithNameContain",
				System.currentTimeMillis() - startTime,
				String.format("keyword=%s", keyword));
		return books;
	}

	private List<BookDetailDto> findAllBookDetails(List<Long> bookIds) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<BookDetailDto> query = cb.createQuery(BookDetailDto.class);
		Root<BookDetail> rBookDetails = query.from(BookDetail.class);

		CriteriaBuilder.In<Long> inClause = cb.in(rBookDetails.get("book").get("id"));
		for (Long bookId : bookIds) {
			inClause.value(bookId);
		}

		query
				.select(cb.construct(
						BookDetailDto.class
						, rBookDetails.get("id")
						, rBookDetails.get("source")
						, rBookDetails.get("description")
						, rBookDetails.get("coverUrl")
						, rBookDetails.get("book").get("id")
				))
				.where(inClause)
		;
		TypedQuery<BookDetailDto> result = entityManager.createQuery(query);
		return result != null ?
				entityManager.createQuery(query).getResultList()
				: Collections.emptyList();
	}

	private List<CommentDto> findAllBookComments(List<Long> bookDetailIds) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<CommentDto> query = cb.createQuery(CommentDto.class);
		Root<Comment> rBookComments = query.from(Comment.class);

		CriteriaBuilder.In<Long> inClause = cb.in(rBookComments.get("bookDetail").get("id"));
		for (Long bookId : bookDetailIds) {
			inClause.value(bookId);
		}

		query
				.select(cb.construct(
						CommentDto.class
						, rBookComments.get("id")
						, rBookComments.get("content")
						, rBookComments.get("bookDetail").get("id")
				))
				.where(inClause)
		;
		TypedQuery<CommentDto> result = entityManager.createQuery(query);
		return result != null ?
				entityManager.createQuery(query).getResultList()
				: Collections.emptyList();
	}

	private List<RatingDto> findAllBookRatings(List<Long> bookDetailIds) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<RatingDto> query = cb.createQuery(RatingDto.class);
		Root<Rating> rBookRatings = query.from(Rating.class);

		CriteriaBuilder.In<Long> inClause = cb.in(rBookRatings.get("bookDetail").get("id"));
		for (Long bookId : bookDetailIds) {
			inClause.value(bookId);
		}

		query
				.select(cb.construct(
						RatingDto.class
						, rBookRatings.get("id")
						, rBookRatings.get("value")
						, rBookRatings.get("bookDetail").get("id")
				))
				.where(inClause)
		;
		TypedQuery<RatingDto> result = entityManager.createQuery(query);
		return result != null ?
				entityManager.createQuery(query).getResultList()
				: Collections.emptyList();
	}

	private List<TagDto> findAllBookTags(List<Long> bookDetailIds) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<TagDto> query = cb.createQuery(TagDto.class);
		Root<Tag> rBookTags = query.from(Tag.class);

		CriteriaBuilder.In<Long> inClause = cb.in(rBookTags.get("bookDetail").get("id"));
		for (Long bookId : bookDetailIds) {
			inClause.value(bookId);
		}

		query
				.select(cb.construct(
						TagDto.class
						, rBookTags.get("id")
						, rBookTags.get("name")
						, rBookTags.get("bookDetail").get("id")
				))
				.where(inClause)
		;
		TypedQuery<TagDto> result = entityManager.createQuery(query);
		return result != null ?
				entityManager.createQuery(query).getResultList()
				: Collections.emptyList();
	}
}

