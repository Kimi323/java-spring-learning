package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// this annotation tells spring this is a java configuration file, not xml.
@Configuration

// parameter is the package name. 
// spring scans the package, find all the classes that have the @component annotation and register in spring container.
//@ComponentScan("com.luv2code.springdemo")

// inject values form property file sports.properties. this file id directly under src/
@PropertySource("classpath:sports.properties")
public class SportConfig {
	
	// define bean for sad fortune service
	@Bean                 // Å´ the bean id
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// define our swim coach and inject dependency
	@Bean        // Å´ the bean id
	public Coach swimCoach() {
		SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
		return mySwimCoach;
	}
}
