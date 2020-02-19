package com.paul.lab1.model;

import java.util.Date;

public class Elective {
    private final String electiveName;
    private final String teacherFullName;
    private final Date startDate;
    private final Date endDate;
    private String[] students;
    private double[][] marks;

    Elective(String electiveName, String teacherFullName, Date startDate,
             Date endDate, String[] students, double[][] marks) {
        this.electiveName = electiveName;
        this.teacherFullName = teacherFullName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = students;
        this.marks = marks;
    }


    public String getElectiveName() {
        return electiveName;
    }

    public String getTeacherFullName() {
        return teacherFullName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String[] getStudents() {
        return students;
    }

    public double[][] getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        String startDateStr = String.valueOf(this.startDate.getDate()) + '/' +
                this.startDate.getMonth() + '/' + this.startDate.getYear();
        String endDateStr = String.valueOf(this.endDate.getDate()) + '/' +
                this.endDate.getMonth() + '/' + this.endDate.getYear();

        StringBuilder studentsStr = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            if (students.length - i == 1) {
                studentsStr.append(students[i]);
            } else {
                studentsStr.append(students[i] + ", ");
            }
        }

        return String.format(
                "%20s | %30s | %10s | %10s | %s",
                electiveName,
                teacherFullName,
                startDateStr,
                endDateStr,
                studentsStr.toString()
        );
    }
}
