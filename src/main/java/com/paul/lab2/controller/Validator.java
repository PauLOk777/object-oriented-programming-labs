package com.paul.lab2.controller;

import com.paul.lab2.controller.validatorExceptions.IncorrectlyElective;
import com.paul.lab2.controller.validatorExceptions.IncorrectlyMainBranching;
import com.paul.lab2.controller.validatorExceptions.IncorrectlyTeacher;

class Validator {
    private static final String BAD_TEACHER_NAME = "Bad full name. Check instruction.";
    private static final String BAD_ELECTIVE_NAME = "Bad elective name. Check instruction.";
    private static final String BAD_QUERY = "Bad query, please read instruction again and choose correct variant.\n\n";

    void checkCorrectnessMainBranching(String data) {
        if (!data.matches("[1-3]|quit")) {
            throw new IncorrectlyMainBranching(BAD_QUERY);
        }
    }

    void checkTeacher(String data) {
        if(!data.matches("^[A-Z][a-z]+\\s+[A-Z][a-z]+\\s+[A-Z][a-z]+"))
            throw new IncorrectlyTeacher(BAD_TEACHER_NAME);
    }

    void checkElective(String data) {
        if(!data.matches("^[A-Z][\\w\\s-]*"))
            throw new IncorrectlyElective(BAD_ELECTIVE_NAME);
    }
}