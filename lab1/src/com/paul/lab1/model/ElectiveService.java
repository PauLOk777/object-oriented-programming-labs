package com.paul.lab1.model;

import java.io.IOException;

public class ElectiveService {
    private Elective[] electives;
    private final static String PATH = "C:\\projects\\object-oriented-programming-labs\\lab1\\data.json";
    private final static String PATH_ELECTIVES = "C:\\projects\\object-oriented-programming-labs\\lab1\\electives.txt";

    public ElectiveService() throws IOException {
//        electives = DataSource.getNewElectives();
        electives = FileIO.readElectivesJSON(PATH);
    }

    public Elective[] getElectives() { return electives; }

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