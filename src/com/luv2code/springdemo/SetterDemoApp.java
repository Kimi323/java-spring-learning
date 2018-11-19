package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		// Coach.class is the interface implemented by all kinds of coach (e.g. TrackCoach class).
		// myCoach is the beanId defined in applicationContext.xml. since we defined class="com.luv2code.springdemo.CricketCoach",
		// spring will create a CricketCoach as the bean.
		// Coach theCoach = context.getBean("myCricketCoach", Coach.class); 
		
		// we cannot use the interface Coach.class if we want to use getEmailAddress() and getTeam() of CricketCoach. 
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// let's call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// call our new methods to get the literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
