package com.flz.reference;

public class User {
    private String name;
    private byte[] content;

    public User(String name) {
        this.name = name;
        this.content = new byte[2 * 1024 * 1024]; // 2m
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
