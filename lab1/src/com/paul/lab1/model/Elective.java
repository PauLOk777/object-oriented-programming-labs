package com.paul.lab1.model;

import java.util.Calendar;

public class Elective {
    private final String electiveName;
    private final String teacherFullName;
    private final Calendar startDate;
    private final Calendar endDate;
    private String[] students;
    private double[][] marks;

    public Elective(String electiveName, String teacherFullName, Calendar startDate,
             Calendar endDate, String[] students, double[][] marks) {
        this.electiveName = electiveName;
        this.teacherFullName = teacherFullName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = students;
        this.marks = marks;
    }


    String getElectiveName() {
        return electiveName;
    }

    String getTeacherFullName() {
        return teacherFullName;
    }

    Calendar getStartDate() {
        return startDate;
    }

    Calendar getEndDate() {
        return endDate;
    }

    String[] getStudents() {
        return students;
    }

    double[][] getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        String startDateStr = String.valueOf(this.startDate.get(Calendar.DAY_OF_MONTH)) + '/' +
                this.startDate.get(Calendar.MONTH) + '/' + this.startDate.get(Calendar.YEAR);
        String endDateStr = String.valueOf(this.endDate.get(Calendar.DAY_OF_MONTH)) + '/' +
                this.endDate.get(Calendar.MONTH) + '/' + this.endDate.get(Calendar.YEAR);

        StringBuilder studentsStr = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            if (students.length - i == 1) {
                studentsStr.append(students[i]);
            } else {
                studentsStr.append(students[i]).append(", ");
            }
        }

        return new String(
                electiveName + "," + teacherFullName + "," +
                        startDateStr + "," + endDateStr +
                        "," +studentsStr.toString()
        );
    }
}
