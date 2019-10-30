package com.axonactive.devdayapp.util;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.domain.Comment;
import com.axonactive.devdayapp.domain.Rating;
import com.axonactive.devdayapp.domain.Tag;
import com.axonactive.devdayapp.dto.CommentDto;
import com.axonactive.devdayapp.dto.RatingDto;
//import com.axonactive.devdayapp.dto.SimpleBookDto;
import com.axonactive.devdayapp.dto.TagDto;

@Mapper(	nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, 
			nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ObjectMapper {
	
    ObjectMapper MAPPER = Mappers.getMapper(ObjectMapper.class);
    
	@InheritInverseConfiguration
	CommentDto CommentToCommentDto(Comment comment, @Context CycleAvoidingMappingContext context);
	
	@InheritInverseConfiguration
	RatingDto RatingToRatingDto(Rating rating, @Context CycleAvoidingMappingContext context);
	
	@InheritInverseConfiguration
	TagDto TagToTagDto(Tag tag, @Context CycleAvoidingMappingContext context);

	//SimpleBookDto toSimpleBookDto(Book book);
}
