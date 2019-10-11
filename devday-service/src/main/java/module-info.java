module service.jmod {
	
	requires repository.jmod;
	requires org.apache.logging.log4j;
	requires org.json;
	requires spring.beans;
	requires spring.context;
	requires com.google.common;
	requires spring.web;
	requires spring.core;
	requires modelmapper;
	requires domain.jmod;
	
	exports com.axonactive.devdayapp.service;
	exports com.axonactive.devdayapp.dto;
	
}