package com.assignment2.assignment2.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private String password;
    private double gpa;
    private int height;
    private int weight;
    private String colour;
    private String ig;
    public User() { 
    }
    public User(String name, String password, double gpa, int height, int weight, String colour, String ig) {
        this.name = name;
        this.password = password;
        this.gpa = gpa;
        this.height = height;
        this.weight = weight;
        this.colour = colour;
        this.ig = ig;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(int gpa) {
        this.gpa = gpa;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getIg() {
        return ig;
    }
    public void setIg(String ig) {
        this.ig = ig;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    
}
