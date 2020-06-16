package com.paul.lab5.controller.validatorExceptions;

public class IncorrectlyElective extends RuntimeException {
    public IncorrectlyElective() {
        super("Some problems with elective.");
    }
    public IncorrectlyElective(String message) {
        super(message);
    }
}
