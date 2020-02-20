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
        return data.matches("^[a-zA-Z ]*$");
    }

    public boolean checkElective(String data) {
        return data.matches("^[a-zA-Z0-9 -]*$");
    }
}
