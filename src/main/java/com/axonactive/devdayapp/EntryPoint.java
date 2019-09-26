package com.axonactive.devdayapp;

import com.axonactive.devdayapp.service.MeService;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class EntryPoint {

    @Autowired
    private MeService srv;

	@RequestMapping("/")
	String home() {
        srv.doIt();
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(EntryPoint.class, args);
	}

}

