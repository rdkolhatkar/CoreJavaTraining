package com.scenarios.ProjectLombokApiLibrary;

import lombok.*;
// With lombok we don't need to write constructor and getter and setter, by using the below annotations we can perform the functions of operations of Constructor, ToString, Getter and Setter methods
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class LombokApiLibraries {
    private String name;
    private int age;
    private String city;
    private boolean isActive;
    private String dob;
/*
    public LombokApiLibraries() {
    }

    public LombokApiLibraries(String name, int age, String city, boolean isActive, String dob) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.isActive = isActive;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "LombokApiLibraries{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", isActive=" + isActive +
                ", dob='" + dob + '\'' +
                '}';
    }

 */
}
