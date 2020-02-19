package com.paul.lab1.model;

import java.util.Date;
import java.util.Random;

public class ElectiveService {
    private static final int numberOfStudents = 5;
    private static final int maxNumberOfMarks = 10;
    private static final int maxMark = 12;

    public Elective[] getElectives() {
        Elective[] electives = new Elective[DataSource.numberOfElectives()];
        String[] electiveNames = DataSource.getElectiveNames();

        for (int i = 0; i < DataSource.numberOfElectives(); i++) {
            electives[i] = new Elective(
                    electiveNames[i],
                    DataSource.getRandomTeacher(),
                    DataSource.getRandomStartDate(),
                    DataSource.getRandomEndDate(),
                    this.getStudents(),
                    this.getMarks()
            );
        }

        return electives;
    }

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
        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < maxNumberOfMarks; j++) {
                sum += marks[i][j];
            }
        }

        return sum / (numberOfStudents * maxNumberOfMarks);
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

    private String[] getStudents() {
        String[] uniqueStudents = new String[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            String student = DataSource.getRandomStudent();
            if (isPart(student, uniqueStudents)) {
                i--;
            } else {
                uniqueStudents[i] = student;
            }
        }

        return uniqueStudents;
    }

    private double[][] getMarks() {
        return DataSource.getRandomMarks(numberOfStudents, maxNumberOfMarks, maxMark);
    }

    private boolean isPart(String currentStr, String[] setOfStrings) {
        for (String tempStr: setOfStrings) {
            if (tempStr == null) continue;
            if (tempStr.equals(currentStr)) {
                return true;
            }
        }
        return false;
    }
}

class DataSource {
    private static final String[] electiveNames = {
            "Physics", "Math", "Computer Science", "Chemistry",
            "Biology", "Ukrainian language", "Ukrainian literature",
            "Ecology", "Economy", "Astronomy"
    };

    private static final String[] teachers = {
            "Ivanov Ivan Ivanovich", "Zaharko Mykola Mykolaevich",
            "Soroka Evgen Sergiyovich", "Guzenko Oleksandr Viktorovich"
    };

    private static final Date[] startDates = {
            new Date(2019, 9, 1),
            new Date(2019, 10, 5),
            new Date(2019, 9, 15)
    };

    private static final Date[] endDates = {
            new Date(2020, 5, 25),
            new Date(2020, 5, 1),
            new Date(2020, 6, 5)
    };

    private static final String[] students = {
            "Trotsiuk Pavlo", "Kemarskiy Mykyta", "Myronyuk Pavlo",
            "Chuy Oleg", "Chugay Vladislava", "Galun Anna", "Panasyuk Vitaliy",
            "Pavlyuk Olena", "Knysh Vladislav", "Filatov Oleksandr",
            "Verko Olga", "Sharikov Sergiy", "Krasnovil Oleg"
    };

    public static int numberOfElectives() {
        return electiveNames.length;
    }

    public static String[] getElectiveNames() {
        return electiveNames;
    }

    public static String getRandomTeacher() {
        Random rand = new Random();
        int randomTeacherIndex = rand.nextInt(teachers.length);
        return teachers[randomTeacherIndex];
    }

    public static String getRandomStudent() {
        Random rand = new Random();
        int randomStudentIndex = rand.nextInt(students.length);
        return students[randomStudentIndex];
    }

    public static Date getRandomStartDate() {
        Random rand = new Random();
        int randomStartDateIndex = rand.nextInt(startDates.length);
        return startDates[randomStartDateIndex];
    }

    public static Date getRandomEndDate() {
        Random rand = new Random();
        int randomEndDateIndex = rand.nextInt(endDates.length);
        return endDates[randomEndDateIndex];
    }

    public static double[][] getRandomMarks(int numberOfStudents, int maxNumberOfMarks, int maxMark) {
        double[][] marks = new double[numberOfStudents][maxNumberOfMarks];
        Random rand = new Random();

        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < maxNumberOfMarks; j++) {
                marks[i][j] = rand.nextInt(maxMark + 1);
            }
        }

        return marks;
    }
}