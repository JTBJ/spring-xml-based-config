package com.spring.xml_based_config.coachImpl;

import com.spring.xml_based_config.coach.Coach;
import com.spring.xml_based_config.dependency.FortuneService;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
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
