package com.axonactive.devdayapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter	
@Setter
public class DeviceDto {
	private Long id;
    private UserDto user;
    private String status;
    private String token;

}

