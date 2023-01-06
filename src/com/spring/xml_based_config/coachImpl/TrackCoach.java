package com.spring.xml_based_config.coachImpl;

import com.spring.xml_based_config.coach.Coach;
import com.spring.xml_based_config.dependency.FortuneService;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    //BEAN LIFECYCLE
    /*
     * container starts
     * beans get instantiated
     * internal spring processing
     * custom init(); method executes - if exists
     * bean ready for use
     * container shuts down
     * custom destroy(); method executes - if present
     * bean lifecycle ends and app stops
     */

    //LIFECYCLE method demonstration
    private void init() {
        System.out.println("***** lifecycle method init(); on singleton bean example  *****");
        System.out.println("Inside spring lifecycle method INIT called by the spring container.");
        System.out.println("initialization lifecycle callback methods are called on all objects regardless of scope");
        System.out.println();
    }

    //LIFECYCLE method demonstration
    private void destroy() {
        System.out.println("***** lifecycle method destroy(); on singleton bean example  *****");
        System.out.println("Inside spring lifecycle method DESTROY called by the spring container.");
        System.out.println("For \"prototype\" scoped beans, Spring does not call the destroy method.");
        System.out.println("The client code must clean up prototype-scoped objects and release expensive\n" +
                "resources that the prototype bean(s) are holding. ");
        System.out.println();
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k.";
    }

    @Override
    public String getDailyFortune() {
        return "Baseball coach " + fortuneService.getFortune();
    }
}
