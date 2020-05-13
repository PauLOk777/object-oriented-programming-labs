package com.paul.lab1.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ElectiveService {
    private Elective[] electives;
    private final static String PATH_TO_READ_ELECTIVES =
            "C:\\projects\\object-oriented-programming-labs\\data.json";
    private final static String PATH_TO_SAVE_ELECTIVES =
            "C:\\projects\\object-oriented-programming-labs\\electives.txt";
    private static Logger logger = LogManager.getLogger();

    public ElectiveService() throws IOException {
//        electives = DataSource.getNewElectives();
        electives = FileIO.readElectivesJSON(PATH_TO_READ_ELECTIVES);
    }

    public String[] getElectives() {
        String[] result = new String[electives.length];

        for (int i = 0; i < electives.length; i++) {
            result[i] = electives[i].toString();
        }

        for (String elective: result) {
            logger.debug(elective);
        }

        return result;
    }

    public void writeTextElectives(String electives) throws IOException {
        FileIO.writeElectivesToTXT(electives, PATH_TO_SAVE_ELECTIVES);
    }

    public double getAverageMark(String electiveName) {
        Elective searchedElective = null;
        for (Elective elective: electives) {
            if (elective.getElectiveName().equals(electiveName)) {
                searchedElective = elective;
                break;
            }
        }

        if (searchedElective == null) {
            logger.error("No such electives.");
            return -1;
        }

        double sum = 0;
        double[][] marks = searchedElective.getMarks();
        for (double[] markElective : marks) {
            for (double note : markElective) {
                sum += note;
            }
        }

        double result = sum / (marks.length * marks[0].length);
        logger.debug("Average mark in " + electiveName + ": " + result);
        return result;
    }

    public String getElectivesFromOneTeacher(String teacher) {
        StringBuilder searchedElectives = new StringBuilder();
        for (Elective elective: electives) {
            if(elective.getTeacherFullName().equals(teacher)) {
                searchedElectives.append(elective.getElectiveName()).append("\n");
            }
        }

        String result = searchedElectives.toString();
        logger.debug("\n" + result);
        return result;
    }
}