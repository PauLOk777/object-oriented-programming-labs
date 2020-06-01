package com.paul.lab5.model;

import java.util.Calendar;

public class Elective {
    private String electiveName;
    private String teacherFullName;
    private Calendar startDate;
    private Calendar endDate;
    private String[] students;
    private double[][] marks;

    Elective(String electiveName, String teacherFullName, Calendar startDate,
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

    void setElectiveName(String electiveName) {
        this.electiveName = electiveName;
    }

    void setTeacherFullName(String teacherFullName) {
        this.teacherFullName = teacherFullName;
    }

    void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    void setStudents(String[] students) {
        this.students = students;
    }

    void setMarks(double[][] marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        String startDateStr = String.valueOf(this.startDate.get(Calendar.DAY_OF_MONTH)) + '/' +
                (this.startDate.get(Calendar.MONTH) + 1) + '/' + this.startDate.get(Calendar.YEAR);
        String endDateStr = String.valueOf(this.endDate.get(Calendar.DAY_OF_MONTH)) + '/' +
                (this.endDate.get(Calendar.MONTH) + 1) + '/' + this.endDate.get(Calendar.YEAR);

        StringBuilder studentsStr = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            if (students.length - i == 1) {
                studentsStr.append(students[i]);
            } else {
                studentsStr.append(students[i]).append(", ");
            }
        }

        return electiveName + "," + teacherFullName + "," +
                startDateStr + "," + endDateStr +
                "," + studentsStr.toString();
    }
}
