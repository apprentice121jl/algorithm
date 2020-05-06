package com.jl.meet.delete;

/**
 * JL
 * 2020/4/27  14:48
 **/
public class User {
    private int age;

    public User(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }
}
