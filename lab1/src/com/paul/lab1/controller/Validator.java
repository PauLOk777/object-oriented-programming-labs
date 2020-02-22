package com.paul.lab1.controller;

public class Validator {
    public boolean checkCorrectnessMainBranching(String data) {
        if (data.equals("1") || data.equals("2")
        || data.equals("3") || data.equals("quit")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkTeacher(String data) {
        return data.matches("^[A-Z][a-z]+\\s[A-Z][a-z]+\\s[A-Z][a-z]+");
    }

    public boolean checkElective(String data) {
        return data.matches("^[A-Z][\\w\\s-]*");
    }
}
