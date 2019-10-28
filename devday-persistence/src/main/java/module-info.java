module persistence.jmod {
	
	requires domain.jmod;
	requires spring.data.commons;
	requires java.persistence;
	requires spring.data.jpa;
	requires spring.context;
	
	exports com.axonactive.devdayapp.repo;
}