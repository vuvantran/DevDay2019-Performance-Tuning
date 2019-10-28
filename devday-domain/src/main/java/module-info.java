module domain.jmod {
	
	requires java.persistence;

	opens com.axonactive.devdayapp.domain; 
	
	exports com.axonactive.devdayapp.domain;
	exports com.axonactive.devdayapp.enums;
}