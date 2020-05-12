package com.paul.lab1.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class RetrieveInfo {
    private Scanner scanner = new Scanner(System.in);
    private static Logger logger = LogManager.getLogger();

    public String getUserLine() {
        String input = scanner.nextLine();
        logger.debug("User input: " + input);
        return input;
    }
}
