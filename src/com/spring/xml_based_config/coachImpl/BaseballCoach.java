package com.spring.xml_based_config.coachImpl;

import com.spring.xml_based_config.coach.Coach;
import com.spring.xml_based_config.dependency.FortuneService;

public class BaseballCoach implements Coach {

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
}
