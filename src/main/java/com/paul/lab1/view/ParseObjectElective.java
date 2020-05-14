package com.paul.lab1.view;

class ParseObjectElective {
    static final String FORMAT = "%20s | %30s | %15s | %15s | %s\n";
    static String parseToString(String data) {
        String[] parsedInfo = data.split(",", 5);
        return String.format(
                FORMAT, parsedInfo[0], parsedInfo[1],
                parsedInfo[2], parsedInfo[3], parsedInfo[4]
        );
    }
}
