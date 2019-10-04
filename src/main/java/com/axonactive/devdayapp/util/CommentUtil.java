package com.axonactive.devdayapp.util;

import com.axonactive.devdayapp.domain.Comment;
import com.axonactive.devdayapp.dto.CommentDto;

public class CommentUtil {
	public static CommentDto toCommentDto(Comment comment) {
		if(null == comment) {
			return null;
		}else {
			CommentDto dto = new CommentDto();
			dto.setId(comment.getId());
			dto.setContent(comment.getContent());
			dto.setParentId(comment.getParent().getId());
			return dto;
		}
	}
}
