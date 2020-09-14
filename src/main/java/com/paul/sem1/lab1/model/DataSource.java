package com.paul.sem1.lab1.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class DataSource {
    public static final int NUMBER_OF_STUDENTS = 5;
    public static final int MAX_NUMBER_OF_MARKS = 10;
    public static final int MAX_MARK = 12;

    private static final String[] electiveNames = {
            "Physics", "Math", "Computer Science", "Chemistry",
            "Biology", "Ukrainian language", "Ukrainian literature",
            "Ecology", "Economy", "Astronomy"
    };

    private static final String[] teachers = {
            "Ivanov Ivan Ivanovich", "Zaharko Mykola Mykolaevich",
            "Soroka Evgen Sergiyovich", "Guzenko Oleksandr Viktorovich"
    };

    private static final Calendar[] startDates = {
            new GregorianCalendar(2019, 9, 1),
            new GregorianCalendar(2019, 10, 5),
            new GregorianCalendar(2019, 9, 15)
    };

    private static final Calendar[] endDates = {
            new GregorianCalendar(2020, 5, 25),
            new GregorianCalendar(2020, 5, 1),
            new GregorianCalendar(2020, 6, 5)
    };

    private static final String[] students = {
            "Trotsiuk Pavlo", "Kemarskiy Mykyta", "Myronyuk Pavlo",
            "Chuy Oleg", "Chugay Vladislava", "Galun Anna", "Panasyuk Vitaliy",
            "Pavlyuk Olena", "Knysh Vladislav", "Filatov Oleksandr",
            "Verko Olga", "Sharikov Sergiy", "Krasnovil Oleg"
    };

    public static Elective[] getNewElectives() {
        Elective[] electives = new Elective[DataSource.numberOfElectives()];
        String[] electiveNames = DataSource.getElectiveNames();

        for (int i = 0; i < DataSource.numberOfElectives(); i++) {
            electives[i] = new Elective(
                    electiveNames[i],
                    DataSource.getRandomTeacher(),
                    DataSource.getRandomStartDate(),
                    DataSource.getRandomEndDate(),
                    DataSource.getStudents(),
                    DataSource.getRandomMarks()
            );
        }

        return electives;
    }

    private static int numberOfElectives() {
        return electiveNames.length;
    }

    private static String[] getElectiveNames() {
        return electiveNames;
    }

    private static String getRandomTeacher() {
        Random rand = new Random();
        int randomTeacherIndex = rand.nextInt(teachers.length);
        return teachers[randomTeacherIndex];
    }

    private static String getRandomStudent() {
        Random rand = new Random();
        int randomStudentIndex = rand.nextInt(students.length);
        return students[randomStudentIndex];
    }

    private static Calendar getRandomStartDate() {
        Random rand = new Random();
        int randomStartDateIndex = rand.nextInt(startDates.length);
        return startDates[randomStartDateIndex];
    }

    private static Calendar getRandomEndDate() {
        Random rand = new Random();
        int randomEndDateIndex = rand.nextInt(endDates.length);
        return endDates[randomEndDateIndex];
    }

    private static double[][] getRandomMarks() {
        double[][] marks = new double[NUMBER_OF_STUDENTS][MAX_NUMBER_OF_MARKS];
        Random rand = new Random();

        for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            for (int j = 0; j < MAX_NUMBER_OF_MARKS; j++) {
                marks[i][j] = rand.nextInt(MAX_MARK + 1);
            }
        }

        return marks;
    }

    private static String[] getStudents() {
        String[] uniqueStudents = new String[NUMBER_OF_STUDENTS];

        for (int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            String student = DataSource.getRandomStudent();
            if (isPart(student, uniqueStudents)) {
                i--;
            } else {
                uniqueStudents[i] = student;
            }
        }

        return uniqueStudents;
    }

    private static boolean isPart(String currentStr, String[] setOfStrings) {
        for (String tempStr: setOfStrings) {
            if (tempStr == null) continue;
            if (tempStr.equals(currentStr)) {
                return true;
            }
        }
        return false;
    }
}