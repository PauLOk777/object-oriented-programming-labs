package com.paul.sem1.lab2.controller.validatorExceptions;

public class IncorrectlyMainBranching extends RuntimeException {
    public IncorrectlyMainBranching() { super("Some problems with main branching."); }
    public IncorrectlyMainBranching(String message) { super(message); }
}
