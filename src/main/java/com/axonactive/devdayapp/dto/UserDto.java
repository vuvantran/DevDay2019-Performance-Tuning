package com.axonactive.devdayapp.dto;

import java.util.Date;
import java.util.List;

import com.axonactive.devdayapp.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter	
@Setter
public class UserDto {

	private Long id;
	@JsonIgnore
	private String username;
	@JsonIgnore
	private String password;
    private String fullName;
    private String email;
    @JsonIgnore
    private Date createAt;
    @JsonIgnore
    private List<CommentDto> comments;
    
    private List<DeviceDto> devices;
    @JsonIgnore
    private List<RatingDto> ratings;
    @JsonIgnore
    private List<BookDto> bookInWishList;
    public static UserDto fromEntity(User entity) {
        if (entity == null) return null;
        UserDto dto = new UserDto();
        dto.id = entity.getId();
        dto.username = entity.getUsername();
        dto.password = entity.getPassword();
        dto.fullName = entity.getFullName();
        dto.email = entity.getEmail();
        dto.createAt = entity.getCreateAt();
        return dto;
    }

    
    public static User toEntity(UserDto userDto) {
    	if (userDto == null) return null;
    	User entityUser = new User();
    	entityUser.setId(userDto.getId());
    	entityUser.setUsername(userDto.getUsername());
    	entityUser.setPassword(userDto.getPassword());
    	entityUser.setFullName(userDto.getFullName());
    	entityUser.setEmail(userDto.getEmail());
    	entityUser.setCreateAt(userDto.getCreateAt());
    	return entityUser;
    }
}
