package main.java.com.paul.lab1.model;

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
        return new String();
    }
}
