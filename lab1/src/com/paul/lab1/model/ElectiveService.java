package com.paul.lab1.model;

public class ElectiveService {
    private Elective[] electives;

    public ElectiveService() {
        electives = DataSource.getNewElectives();
    }

    public Elective[] getElectives() { return electives; }

    public double getAverageMark(Elective[] electives, String electiveName) {
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
        for (int i = 0; i < DataSource.NUMBER_OF_STUDENTS; i++) {
            for (int j = 0; j < DataSource.MAX_NUMBER_OF_MARKS; j++) {
                sum += marks[i][j];
            }
        }

        return sum / (DataSource.NUMBER_OF_STUDENTS * DataSource.MAX_NUMBER_OF_MARKS);
    }

    public String getElectivesFromOneTeacher(Elective[] electives, String teacher) {
        StringBuilder searchedElectives = new StringBuilder();
        for (Elective elective: electives) {
            if(elective.getTeacherFullName().equals(teacher)) {
                searchedElectives.append(elective.getElectiveName() + "\n");
            }
        }
        return searchedElectives.toString();
    }
}