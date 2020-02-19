package com.paul.lab1.view;

public class Validator {
    public int checkCorrectness(String data) {
        switch (data) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "quit":
                return 3;
            default:
                return -1;
        }
    }
}
