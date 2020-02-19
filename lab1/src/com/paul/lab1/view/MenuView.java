package com.paul.lab1.view;

import com.paul.lab1.model.Elective;

public class MenuView {
    public void showAbilities() {
        System.out.println(
                "To select the option, write number of this and press enter:\n" +
                        "1. Get a list of electives that " +
                        "are taught by the instructor specified.\n"  +
                        "2. Get an average student score" +
                        "for the specified elective.\n" +
                        "3. Get all electives.\n" +
                        "If you want to exit from this app, write \"quit\"."
        );
    }

    public void showAllElectives(Elective[] electives) {
        System.out.printf(
                "%20s | %30s | %10s | %10s | %s%n",
                "Elective name", "Teacher", "Start date",
                "End date", "Students"
        );

        for (Elective elective: electives) {
            System.out.println(elective);
        }
        System.out.println("\n");
    }

    public void showElectives(String result) {
        if(result.isEmpty()) {
            System.out.println("This teacher does not teach anything\n\n");
        } else {
            System.out.println("Elective name\n" + result);
        }
    }

    public void averageMark(String electiveName, double average) {
        if(average == -1) {
            System.out.println("No any elective with this name.\n\n");
        } else {
            System.out.println("Average mark of " + electiveName + ": " + average + "\n\n");
        }
    }

    public void invitationToWriteTeacher() {
        System.out.println("Write full name of teacher. For example: \"Ivanov Ivan Ivanovich\".");
    }

    public void invitationToWriteElective() {
        System.out.println("Write name of elective. For example: \"Ukrainian language\".");
    }

    public void badTeacherName() {
        System.out.println("Bad name. Check instruction.");
    }

    public void badElectiveName() {
        System.out.println("Bad name. Check instruction.");
    }

    public void badQuery() {
        System.out.println("Bad query, please read instruction again and choose correct variant.");
    }

    public void quit() {
        System.out.println("Goodbye!");
    }
}
