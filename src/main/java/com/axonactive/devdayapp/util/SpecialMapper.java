package com.axonactive.devdayapp.util;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.axonactive.devdayapp.domain.Comment;
import com.axonactive.devdayapp.domain.User;
import com.axonactive.devdayapp.dto.CommentDto;
import com.axonactive.devdayapp.dto.UserDto;

@Mapper
public interface SpecialMapper {

	SpecialMapper SMAPPER = Mappers.getMapper(SpecialMapper.class);

	@InheritInverseConfiguration
	@Mapping(target = "user", ignore = true)
	@Mapping(target = "bookDetail", ignore = true)
	@Mapping(target = "parent", ignore = true)
	CommentDto toCommentDto(Comment comment, @Context CycleAvoidingMappingContext context );
	
	@Mapping(target = "comments", ignore = true)
	@Mapping(target = "devices", ignore = true)
	@Mapping(target = "ratings", ignore = true)
	@Mapping(target = "bookInWishList", ignore = true)
	UserDto userToUserDto(User u, @Context CycleAvoidingMappingContext context );
}
