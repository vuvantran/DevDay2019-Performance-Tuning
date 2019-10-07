package com.axonactive.devdayapp.util;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.axonactive.devdayapp.domain.BookDetail;
import com.axonactive.devdayapp.dto.BookDetailDto;

public class BookDetailUtil {
	public static BookDetailDto toBookDetailDto(BookDetail bookDetail) {
		if(null == bookDetail) {
			return null;
		}else {
			BookDetailDto detailDto = new BookDetailDto();
			detailDto.setId(bookDetail.getId());
			detailDto.setDescription(bookDetail.getDescription());
			detailDto.setCoverUrl(bookDetail.getCoverUrl());
			detailDto.setSource(bookDetail.getSource());
			try {
				detailDto.setTags(StreamSupport.stream(bookDetail.getTags().spliterator(),false)
						.map(tag -> TagUtil.toTagDto(tag))
			            .collect(Collectors.toList()));
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
			try {
				detailDto.setComments(StreamSupport.stream(Optional.ofNullable(bookDetail.getComments()).orElse(Collections.emptyList()).spliterator(),false)
						.map(comment -> CommentUtil.toCommentDto(comment))
			            .collect(Collectors.toList()));
				
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
			return detailDto;
		}
	}
}

