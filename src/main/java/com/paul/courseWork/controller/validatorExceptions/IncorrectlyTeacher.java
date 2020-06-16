package com.paul.lab5.controller.validatorExceptions;

public class IncorrectlyTeacher extends RuntimeException {
    public IncorrectlyTeacher() { super("Some problems with teacher."); }
    public IncorrectlyTeacher(String message) { super(message); }
}
