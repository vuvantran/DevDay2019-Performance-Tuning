package com.axonactive.devdayapp.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.axonactive.devdayapp.datafetcher.AllBooksDataFetcher;
import com.axonactive.devdayapp.datafetcher.BookDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
@Service
public class GraphQLService {
	private static final Logger log = LogManager.getLogger(GraphQLService.class);
	@Autowired
	private AllBooksDataFetcher allBooksDataFetcher;
	@Autowired
	BookDataFetcher bookDataFetcher;
	
	private GraphQL graphQL;
	@Value("classpath:graphql/bookql.graphql")
    Resource resource;
	@PostConstruct
    private void loadSchema() throws IOException {
       

        //Get the graphql file
        File file = resource.getFile();

        //Parse SchemaF
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
        RuntimeWiring runtimeWiring = buildRuntimeWiring();
        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }
	private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                .dataFetcher("allBooks", allBooksDataFetcher)
                .dataFetcher("book", bookDataFetcher)
                		)
                 .build();
    }

    public GraphQL getGraphQL(){
        return graphQL;
    }
}
