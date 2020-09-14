package com.paul.sem1.lab1.controller;

public class Validator {
    public boolean checkCorrectnessMainBranching(String data) {
        return data.matches("[1-3]|quit");
    }

    public boolean checkTeacher(String data) {
        return data.matches("^[A-Z][a-z]+\\s+[A-Z][a-z]+\\s+[A-Z][a-z]+");
    }

    public boolean checkElective(String data) {
        return data.matches("^[A-Z][\\w\\s-]*");
    }
}