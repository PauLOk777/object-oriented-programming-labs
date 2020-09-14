package com.paul.sem1.courseWork.controller.validatorExceptions;

public class IncorrectlyElective extends RuntimeException {
    public IncorrectlyElective() {
        super("Some problems with elective.");
    }
    public IncorrectlyElective(String message) {
        super(message);
    }
}
