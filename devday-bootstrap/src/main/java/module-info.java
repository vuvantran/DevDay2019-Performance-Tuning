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
	requires spring.security.core;
	requires spring.security.config;
	requires spring.core;
	requires springfox.assembly;
}