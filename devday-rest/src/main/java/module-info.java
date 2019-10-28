module rest.jmod {
	
	requires transitive service.jmod;
	requires org.apache.logging.log4j;
	requires spring.web;
	requires spring.beans;
	requires spring.security.core;
	
	opens com.axonactive.devdayapp.rest to spring.core;
	
	exports com.axonactive.devdayapp.rest;
}