module bootstrap.jmod {
	
	requires rest.jmod;
	
	requires java.base;
	requires spring.context;
	requires springfox.swagger2;
	requires springfox.spring.web;
	requires spring.boot.autoconfigure;
	requires spring.boot;
	requires spring.beans;
	requires spring.plugin.core;
	requires com.google.common;
	requires spring.security.web;
	requires spring.security.core;
	requires spring.security.config;
	requires spring.core;
	requires springfox.assembly;
	requires static javax.servlet.api;
	
	opens com.axonactive.devdayapp to spring.core;
	opens com.axonactive.devdayapp.config to spring.core, spring.beans, spring.context;
	
	exports com.axonactive.devdayapp to spring.beans, spring.context;
}