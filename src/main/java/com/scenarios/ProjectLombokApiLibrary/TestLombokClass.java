package com.scenarios.ProjectLombokApiLibrary;

public class TestLombokClass {
    public static void main(String[] args) {
        LombokApiLibraries lombokApiLibraries = new LombokApiLibraries();
        lombokApiLibraries.setName("Ratnakar");
        lombokApiLibraries.setAge(22);
        lombokApiLibraries.setActive(true);
        lombokApiLibraries.setDob("01-01-2026");
        lombokApiLibraries.setCity("Pune");
        System.out.println(lombokApiLibraries.getName());
        System.out.println(lombokApiLibraries.getAge());
        System.out.println(lombokApiLibraries.getCity());
        System.out.println(lombokApiLibraries.isActive());
        System.out.println(lombokApiLibraries.getDob());
        System.out.println("*****************************************************************");
        LombokApiLibraries lombokApi = new LombokApiLibraries("Jay", 20, "Mumbai", true, "01-01-2026");
        System.out.println(lombokApi.getName());
        System.out.println(lombokApi.getAge());
        System.out.println(lombokApi.getCity());
        System.out.println(lombokApi.isActive());
        System.out.println(lombokApi.getDob());
    }
}
