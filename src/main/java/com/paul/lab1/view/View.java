package com.paul.lab1.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    public static String langMenu = "lang_menu";
    public static String mainMenu = "main_menu";
    public static String quit = "quit";
    public static String invitationToWriteTeacher = "invitation_to_write_teacher";
    public static String invitationToWriteElective = "invitation_to_write_elective";
    public static String invitationToRecordInFile = "invitation_to_record_in_file";
    public static String fileNotFound = "file_not_found";
    public static String fileException = "file_exception";
    public static String successfulSave = "successful_save";
    public static String incorrectMainBranching = "incorrect_main_branching";
    public static String incorrectTeacher = "incorrect_teacher";
    public static String incorrectElective = "incorrect_elective";
    private static String teacherWithoutElectives = "teacher_without_electives";
    private static String electiveName = "elective_name";
    private static String noElectives = "no_electives";
    private static String averageMark = "average_mark";
    private static String teacher = "teacher";
    private static String startDate = "start_date";
    private static String endDate = "end_date";
    private static String students = "students";

    private static Logger logger = LogManager.getLogger();

    private static Locale locale;
    private static ResourceBundle resourceBundle;

    static {
        locale = Locale.getDefault();
        logger.debug("User default locale: " + locale.getLanguage() + "-" + locale.getCountry());
        resourceBundle = ResourceBundle.getBundle("text", locale);
    }

    public void setLocaleAndResBundle(Locale locale) {
        View.locale = locale;
        Locale.setDefault(locale);
        logger.debug("User changed default locale to: " + locale.getLanguage() + "-" + locale.getCountry());
        resourceBundle = ResourceBundle.getBundle("text");
    }

    public void printOneMessage(String data) {
        String value = resourceBundle.getString(data);
//        byte[] bytes = resourceBundle.getString(data).getBytes();

//        for (byte character: bytes) System.out.println((char) character);

        System.out.println(value);
        logger.debug(value);
    }

    public void showAllElectives(String[] electives) {
        System.out.printf(ParseObjectElective.FORMAT,
                resourceBundle.getString(electiveName),resourceBundle.getString(teacher),
                resourceBundle.getString(startDate), resourceBundle.getString(endDate),
                resourceBundle.getString(students));

        for (String elective: electives) {
            System.out.print(ParseObjectElective.parseToString(elective));
        }

        System.out.println("\n");
    }

    public void showElectives(String result) {
        if(result.isEmpty()) {
            System.out.println(resourceBundle.getString(teacherWithoutElectives));
        } else {
            System.out.println(resourceBundle.getString(electiveName) + "\n" + result);
        }
    }

    public void averageMark(String electiveName, double average) {
        if(average == -1) {
            System.out.println(resourceBundle.getString(noElectives));
        } else {
            System.out.println(resourceBundle.getString(averageMark) + " " + electiveName + ": " + average + "\n");
        }
    }
}
