package com.paul.lab2.view;

public class ParseObjectElective {
    public static final String FORMAT = "%20s | %30s | %10s | %10s | %s\n";
    public static String parseToString(String data) {
        String[] parsedInfo = data.split(",", 5);
        return String.format(
                FORMAT, parsedInfo[0], parsedInfo[1],
                parsedInfo[2], parsedInfo[3], parsedInfo[4]
        );
    }
}