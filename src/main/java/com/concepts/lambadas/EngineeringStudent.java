package com.concepts.lambadas;

public class EngineeringStudent implements Student{
    @Override
    public String getBioData(String name) {
        return name + " is Engineering Student !";
    }
}
