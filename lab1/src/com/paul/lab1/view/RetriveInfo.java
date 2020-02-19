package com.paul.lab1.view;

import java.util.Scanner;

public class RetriveInfo {
    private static final Scanner input = new Scanner(System.in);

    public String getUserLine() {
        String result = input.nextLine();
        return result;
    }
}
