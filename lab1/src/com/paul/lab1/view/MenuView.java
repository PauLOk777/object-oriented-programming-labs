package com.paul.lab1.view;

import com.paul.lab1.model.Elective;

public class MenuView {
    public static final String mainMenu = "To select the option, write number of this and press enter:\n" +
            "1. Get a list of electives that " +
            "are taught by the instructor specified.\n"  +
            "2. Get an average student score " +
            "for the specified elective.\n" +
            "3. Get all electives.\n" +
            "If you want to exit from this app, write \"quit\".";
    public static final String invitationToWriteTeacher = "Write full name of teacher. " +
            "For example: \"Ivanov Ivan Ivanovich\".";
    public static final String invitationToWriteElective = "Write name of elective." +
            " For example: \"Ukrainian language\".";
    public static final String badTeacherName = "Bad full name. Check instruction.";
    public static final String badElectiveName = "Bad elective name. Check instruction.";
    public static final String badQuery = "Bad query, please read instruction again and choose correct variant.\n\n";
    public static final String quit = "Goodbye!";

    public void printOneMessage(String data) {
        System.out.println(data);
    }

    public void showAllElectives(Elective[] electives) {
        System.out.printf(
                ParseObjectElective.FORMAT,
                "Elective name", "Teacher", "Start date",
                "End date", "Students"
        );

        for (Elective elective: electives) {
            System.out.print(ParseObjectElective.parseToString(elective.toString()));
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
}
