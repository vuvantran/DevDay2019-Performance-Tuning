module rest.jmod {
	
	requires service.jmod;
	requires org.apache.logging.log4j;
	requires spring.web;
	requires spring.beans;
	
	exports com.axonactive.devdayapp.rest;
}