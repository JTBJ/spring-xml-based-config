package com.spring.xml_based_config.dependencyImpl;


import com.spring.xml_based_config.dependency.FortuneService;

public class HappyFortuneServiceImpl implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
