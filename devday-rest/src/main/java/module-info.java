module rest.jmod {
	
	requires transitive service.jmod;
	requires org.apache.logging.log4j;
	requires spring.web;
	requires spring.beans;
	requires spring.security.core;
	
	exports com.axonactive.devdayapp.rest;
}