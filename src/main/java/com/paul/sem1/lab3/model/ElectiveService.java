package com.paul.sem1.lab3.model;

import java.io.IOException;

public class ElectiveService {
    private Elective[] electives;
    private final static String PATH = "C:\\projects\\object-oriented-programming-labs\\data.json";
    private final static String PATH_ELECTIVES = "C:\\projects\\object-oriented-programming-labs\\electives.txt";

    public ElectiveService() throws IOException {
//        electives = DataSource.getNewElectives();
        electives = FileIO.readElectivesJSON(PATH);
    }

    public String[] getElectives() {
        String[] result = new String[electives.length];

        for (int i = 0; i < electives.length; i++) {
            result[i] = electives[i].toString();
        }

        return result;
    }

    public void writeTextElectives(String electives) throws IOException {
        FileIO.writeElectivesToTXT(electives, PATH_ELECTIVES);
    }

    public double getAverageMark(String electiveName) {
        Elective searchedElective = null;
        for (Elective elective: electives) {
            if (elective.getElectiveName().equals(electiveName)) {
                searchedElective = elective;
                break;
            }
        }

        if (searchedElective == null) return -1;

        double sum = 0;
        double[][] marks = searchedElective.getMarks();
        for (double[] markElective : marks) {
            for (double note : markElective) {
                sum += note;
            }
        }

        return sum / (marks.length * marks[0].length);
    }

    public String getElectivesFromOneTeacher(String teacher) {
        StringBuilder searchedElectives = new StringBuilder();
        for (Elective elective: electives) {
            if(elective.getTeacherFullName().equals(teacher)) {
                searchedElectives.append(elective.getElectiveName()).append("\n");
            }
        }
        return searchedElectives.toString();
    }
}