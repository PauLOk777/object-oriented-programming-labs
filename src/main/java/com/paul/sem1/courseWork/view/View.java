package com.paul.sem1.courseWork.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class View {
    private static Logger logger = LogManager.getLogger();
    private static ResourceManager resourceManager;

    static {
        resourceManager = new ResourceManager();
        logger.info("User default locale: " + resourceManager.getLanguage() + "-" + resourceManager.getCountry());
    }

    public void setLocaleAndResBundle(Locale locale) {
        resourceManager.setLocale(locale);
        logger.info("User changed default locale to: " + locale.getLanguage() + "-" + locale.getCountry());
    }

    public void printOneMessage(String data) {
        String value = resourceManager.getValue(data);
        new PrintStream(System.out, true, StandardCharsets.UTF_8).println(value);
        logger.debug(value);
    }

    public void showAllElectives(String[] electives) {
        new PrintStream(System.out, true, StandardCharsets.UTF_8).printf(ParseObjectElective.FORMAT,
                resourceManager.getValue(ResourceBundleKeys.ELECTIVE_NAME),
                resourceManager.getValue(ResourceBundleKeys.TEACHER),
                resourceManager.getValue(ResourceBundleKeys.START_DATE),
                resourceManager.getValue(ResourceBundleKeys.END_DATE),
                resourceManager.getValue(ResourceBundleKeys.STUDENTS)
        );

        for (String elective: electives) {
            System.out.print(ParseObjectElective.parseToString(elective));
        }

        System.out.println("\n");
    }

    public void showElectives(String result) {
        if(result.isEmpty()) {
            new PrintStream(System.out, true, StandardCharsets.UTF_8)
                    .println(resourceManager.getValue(ResourceBundleKeys.TEACHER_WITHOUT_ELECTIVES));
        } else {
            new PrintStream(System.out, true, StandardCharsets.UTF_8)
                    .println(resourceManager.getValue(ResourceBundleKeys.ELECTIVE_NAME) + "\n" + result);
        }
    }

    public void averageMark(String electiveName, double average) {
        if(average == -1) {
            new PrintStream(System.out, true, StandardCharsets.UTF_8)
                    .println(resourceManager.getValue(ResourceBundleKeys.NO_ELECTIVES));
        } else {
            new PrintStream(System.out, true, StandardCharsets.UTF_8)
                    .println(resourceManager.getValue(ResourceBundleKeys.AVERAGE_MARK) +
                            " " + electiveName + ": " + average + "\n");
        }
    }
}
