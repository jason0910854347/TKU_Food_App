package com.example.lan.tku_food_app.Model;

public class User {
    private String Name;
    private String Student_id;
    private String Password;

    public User(){

    };

    public User(String name, String student_id, String password) {
        Name = name;
        Student_id = student_id;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(String student_id) {
        Student_id = student_id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}


