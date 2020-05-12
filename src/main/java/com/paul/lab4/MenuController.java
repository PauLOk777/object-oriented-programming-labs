package com.paul.lab4;

import java.util.Scanner;

public class MenuController {
    private MyCollection myCollection = new MyCollection();

    public void run() {
        while (true) {
            String mainMenu = "To select the option, write number of this option and press enter:\n" +
                    "1. Get a collection of unique by name and type pojo elements.\n" +
                    "2. Fill collection manually.\n" +
                    "3. Fill collection randomly.\n" +
                    "If you want to exit from this app, write \"quit\".";
            System.out.println(mainMenu);
            String option = new Scanner(System.in).nextLine();

            switch (option) {
                case "1":
                    myCollection.getUniqueByNameType();
                    myCollection.showElements();
                    break;
                case "2":
                    myCollection.fillCollectionManually();
                    System.out.println("Successful filling!\nYour collection:\n");
                    myCollection.showElements();
                    break;
                case "3":
                    myCollection.fillCollectionRandomly();
                    System.out.println("Successful filling!\nYour collection:\n");
                    myCollection.showElements();
                    break;
                case "quit":
                    System.out.println("Have a nice day!");
                    return;
                default:
                    System.out.println("Incorrect data. Try more.\n");
            }
        }
    }
}
