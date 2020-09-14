package com.paul.sem1.lab5.controller.validatorExceptions;

public class IncorrectlyElective extends RuntimeException {
    public IncorrectlyElective() {
        super("Some problems with elective.");
    }
    public IncorrectlyElective(String message) {
        super(message);
    }
}
