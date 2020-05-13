package com.paul.lab1.view;

public class View {
    public static final String LANG_MENU = "Change your language (type a number of option):\n" +
            "1. English (default).\n" +
            "2. Russian.\n" +
            "3. Ukrainian.";
    public static final String MAIN_MENU = "To select the option, write number of this option and press enter:\n" +
            "1. Get a list of electives that " +
            "are taught by the instructor specified.\n"  +
            "2. Get an average student score " +
            "for the specified elective.\n" +
            "3. Get all electives.\n" +
            "If you want to exit from this app, write \"quit\".";
    public static final String INVITATION_TO_WRITE_TEACHER = "Write full name of teacher. " +
            "For example: \"Ivanov Ivan Ivanovich\".";
    public static final String INVITATION_TO_WRITE_ELECTIVE = "Write name of elective. " +
            "For example: \"Ukrainian language\".";
    public static final String QUIT = "Goodbye!";
    public static final String INVITATION_TO_RECORD_IN_FILE = "To save this result press 1, to skip - press any button";
    public static final String FILE_NOT_FOUND = "No access. File not found";
    public static final String FILE_EXCEPTION = "No access. Some problems with file";
    public static final String SUCCESSFUL_SAVE = "File was saved successfully";
    public static final String INCORRECT_MAIN_BRANCHING = "Invalid option! Try more.";
    public static final String INCORRECT_TEACHER = "Invalid teacher! Try more.";
    public static final String INCORRECT_ELECTIVE = "Invalid elective! Try more.";
    private static final String TEACHER_WITHOUT_ELECTIVES = "This teacher does not teach anything.";
    private static final String ELECTIVE_NAME = "Elective name";
    private static final String NO_ELECTIVES = "No any elective with this name.";
    private static final String AVERAGE_MARK = "Average mark of elective";
    private static final String TEACHER = "Teacher";
    private static final String START_DATE = "Start date";
    private static final String END_DATE = "End date";
    private static final String STUDENTS = "Students";

    public void printOneMessage(String data) {
        System.out.println(data);
    }

    public void showAllElectives(String[] electives) {
        System.out.printf(ParseObjectElective.FORMAT, ELECTIVE_NAME, TEACHER, START_DATE, END_DATE, STUDENTS);

        for (String elective: electives) {
            System.out.print(ParseObjectElective.parseToString(elective));
        }

        System.out.println("\n");
    }

    public void showElectives(String result) {
        if(result.isEmpty()) {
            System.out.println(TEACHER_WITHOUT_ELECTIVES);
        } else {
            System.out.println(ELECTIVE_NAME + "\n" + result);
        }
    }

    public void averageMark(String electiveName, double average) {
        if(average == -1) {
            System.out.println(NO_ELECTIVES);
        } else {
            System.out.println(AVERAGE_MARK + " " + electiveName + ": " + average + "\n");
        }
    }
}
