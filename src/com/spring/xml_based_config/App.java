package com.spring.xml_based_config;

import com.spring.xml_based_config.coach.Coach;
import com.spring.xml_based_config.coachImpl.CricketCoach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class App {

    public static void main(String[] args) {

        //load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get bean from spring container
        Coach bbCoach = context.getBean("bbCoach", Coach.class);
        Coach tCoach = context.getBean("tCoach", Coach.class);

        //didn't code to interface--compiler couldn't see custom method in class
        CricketCoach cCoach = context.getBean("cCoach", CricketCoach.class);
        //coded to interface--casting ex to expose class methods
        Coach cCoach_v2 = context.getBean("cCoach", Coach.class);

        //call methods on the bean
        System.out.println("***** Inversion of Control *****");
        System.out.println(bbCoach.getDailyWorkout());
        System.out.println(tCoach.getDailyWorkout());
        System.out.println(cCoach.getDailyWorkout());
        System.out.println();

        //call method of dependency (constructor injection)
        System.out.println("***** Constructor injection *****");
        System.out.println(bbCoach.getDailyFortune());
        System.out.println(tCoach.getDailyFortune());
        System.out.println();

        //call method of dependency (setter injection)
        System.out.println("***** Setter injection *****");
        System.out.println(cCoach.getDailyFortune());
        System.out.println();

        //call method of dependency (property injection via container)
        System.out.println("***** property injection via container *****");
        System.out.println("Email: " + ((CricketCoach)cCoach_v2).getEmailAddress()); //cast ex
        System.out.println("Team: " + cCoach.getTeam());
        System.out.println();

        //close context
        context.close();

    }
}
