package com.skillcollaboration.skillbasedstudentcollaborationweb.model;

public class Student {

    private int id;
    private String name;
    private String skills;
    private String interest;

    // New fields
    private String username;
    private String password;
    private String role;

    public Student() {
    }

    public Student(int id, String name, String skills, String interest,
                   String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.interest = interest;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Skills
    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    // Interest
    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    // Username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}