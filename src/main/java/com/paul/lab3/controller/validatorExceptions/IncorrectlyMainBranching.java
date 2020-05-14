package com.paul.lab3.controller.validatorExceptions;

public class IncorrectlyMainBranching extends RuntimeException {
    public IncorrectlyMainBranching() { super("Some problems with main branching."); }
    public IncorrectlyMainBranching(String message) { super(message); }
}
