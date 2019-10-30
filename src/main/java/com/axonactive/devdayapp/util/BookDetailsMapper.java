package com.axonactive.devdayapp.util;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.axonactive.devdayapp.domain.BookDetail;
import com.axonactive.devdayapp.dto.BookDetailDto;

@Mapper(uses= {SpecialMapper.class})
public interface BookDetailsMapper {
BookDetailsMapper MAPPER = Mappers.getMapper(BookDetailsMapper.class);

@InheritInverseConfiguration
BookDetailDto BookDetailToBookDetailDto(BookDetail bookDetail, @Context CycleAvoidingMappingContext context);

}
