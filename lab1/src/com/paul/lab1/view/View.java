package com.paul.lab1.view;

import com.paul.lab1.model.Elective;

public class View {
    public static final String MAIN_MENU = "To select the option, write number of this and press enter:\n" +
            "1. Get a list of electives that " +
            "are taught by the instructor specified.\n"  +
            "2. Get an average student score " +
            "for the specified elective.\n" +
            "3. Get all electives.\n" +
            "If you want to exit from this app, write \"quit\".";
    public static final String INVITATION_TO_WRITE_TEACHER = "Write full name of teacher. " +
            "For example: \"Ivanov Ivan Ivanovich\".";
    public static final String INVITATION_TO_WRITE_ELECTIVE = "Write name of elective." +
            " For example: \"Ukrainian language\".";
    public static final String QUIT = "Goodbye!";
    public static final String INVITATION_TO_RECORD_IN_FILE = "To save this result press 1, to skip - press any button";
    public static final String FILE_NOT_FOUND = "File not found";
    public static final String FILE_EXCEPTION = "Some problems with file";
    public static final String SUCCESSFUL_SAVE = "File was saved successfully";

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
