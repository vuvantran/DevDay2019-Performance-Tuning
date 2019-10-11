module bootstrap.jmod {
	
	requires rest.jmod;
	
	requires java.base;
	requires spring.context;
//	requires springfox.swagger2;
//	requires springfox.core;
//	requires springfox.spring.web;
//	requires springfox.spi;
	requires spring.boot.autoconfigure;
	requires spring.boot;
	requires spring.beans;
	requires spring.plugin.core;
	requires com.google.common;
}