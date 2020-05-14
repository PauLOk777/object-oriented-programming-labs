package com.paul.lab3.view;

import java.util.Scanner;

public class RetrieveInfo {
    private static final Scanner input = new Scanner(System.in);

    public String getUserLine() {
        return input.nextLine();
    }
}