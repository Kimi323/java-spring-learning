package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration java class
		AnnotationConfigApplicationContext context =  // your java configuration class
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// retrieve bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class); 
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// let's call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// call our new swim coach methods. Spring will read data form properties file which is defined in SportConfig.
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
