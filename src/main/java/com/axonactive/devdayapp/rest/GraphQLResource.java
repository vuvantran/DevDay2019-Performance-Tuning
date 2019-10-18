package com.axonactive.devdayapp.rest;

import graphql.ExecutionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axonactive.devdayapp.service.GraphQLService;


@RestController
@RequestMapping("/library-core/graphql")
public class GraphQLResource {
	private static Logger logger = LoggerFactory.getLogger(GraphQLResource.class);
	@Autowired
	private GraphQLService graphQLService;
    
    
    @PostMapping
    public ResponseEntity<Object> getAllBooks(@RequestBody String query){
        logger.info("Entering getAllBooks@BookController");
        ExecutionResult execute = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }

}
