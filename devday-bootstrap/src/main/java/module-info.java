open module bootstrap.jmod {
	
	requires rest.jmod;
	
	requires java.base;
	requires java.desktop;
	requires spring.context;
	requires springfox.swagger2;
	requires springfox.spring.web;
	requires spring.boot.autoconfigure;
	requires spring.boot;
	requires spring.beans;
	requires spring.plugin.core;
	requires spring.security.web;
	requires spring.security.core;
	requires spring.security.config;
	requires spring.core;
	requires spring.aop;
	requires spring.expression;
	requires springfox.assembly;
	requires com.google.common;
	requires commons.logging;
	requires static javax.servlet.api;
	
	exports com.axonactive.devdayapp;
	exports com.axonactive.devdayapp.config;
}