package com.example.sqlite.model;

public class Student {
    int studentID;
    String name;
    String dateOfBirth;
    String email;
    String address;

    public Student() {
    }

    public Student(int studentID, String name, String dateOfBirth, String email, String address) {
        this.studentID = studentID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
    }

    public Student(String name, String dateOfBirth, String email, String address) {

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
