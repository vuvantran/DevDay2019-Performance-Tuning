package com.axonactive.devdayapp.util;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.axonactive.devdayapp.domain.Book;
import com.axonactive.devdayapp.dto.BookDto;

@Mapper(uses = { BookDetailsMapper.class })
public interface BookMapper {
	BookMapper MAPPER = Mappers.getMapper(BookMapper.class);
	
	@InheritInverseConfiguration
	BookDto BookToBookDto(Book book, @Context CycleAvoidingMappingContext context);
	
}
