package com.paul.lab1.view;

public class Validator {
    public int checkCorrectnessMainBranching(String data) {
        switch (data) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "quit":
                return 4;
            default:
                return -1;
        }
    }

    public boolean checkTeacher(String data) {
        return true;
    }

    public boolean checkElective(String data) {
        return true;
    }
}
