package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration java class
		AnnotationConfigApplicationContext context =  // your java configuration class
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("theCoach", Coach.class); 
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// let's call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
