package com.paul.sem2.lab1;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File startFile;

        System.out.println("Type path of the directory.");
        while(true) {
            String path = scanner.nextLine();
            startFile = new File(path);
            if (startFile.isDirectory()) break;
            System.out.println("Incorrect directory. Try again.");
        }

        DirectoryAnalyser dirAn = new DirectoryAnalyser(startFile);
        List<String> javaFiles = dirAn.searchJavaFiles();
        for (String javaFile: javaFiles) System.out.println(javaFile);
    }
}
