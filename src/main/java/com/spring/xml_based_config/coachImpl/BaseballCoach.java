package com.spring.xml_based_config.coachImpl;


import com.spring.xml_based_config.coach.Coach;
import com.spring.xml_based_config.dependency.FortuneService;
import org.springframework.beans.factory.DisposableBean;

public class BaseballCoach implements Coach, DisposableBean {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice.";
    }

    @Override
    public String getDailyFortune() {
        return "Track coach " + fortuneService.getFortune();
    }

    private void init() {
        System.out.println("***** lifecycle method init(); on prototype bean example  *****");
        System.out.println("inside of lifecycle method init(); on prototype scoped bean");
        System.out.println();
    }

    @Override
    public void destroy() {
        System.out.println("***** lifecycle method destroy(); on prototype bean example  *****");
        System.out.println("inside of lifecycle method destroy(); on prototype scoped bean");
        System.out.println("Bean reference " + this);
        System.out.println("The prototype scoped beans MUST implement the DisposableBean interface.\n" +
                            "in order for destroy(); callback to execute. This interface defines a \n" +
                            "\"destroy()\" method.");
        System.out.println();
    }
}
