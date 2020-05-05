package com.paul.lab4;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String args[]) {
        Collection<PlainOldJavaObject> myCollection = new HashSet<>();
        myCollection.add(new PlainOldJavaObject("pavlo", "human", "1.1"));
        myCollection.add(new PlainOldJavaObject("nikita", "human", "1.2"));
        for (PlainOldJavaObject elem: myCollection) {
            System.out.println(elem.getName());
        }
    }
}
