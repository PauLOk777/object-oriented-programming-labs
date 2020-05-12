package com.paul.lab4;

import java.util.*;

public class MyCollection {
    private Collection<PlainOldJavaObject> myCollection;

    MyCollection() {}

    public void fillCollectionRandomly() {
        String[] names = {"Pavlo", "Oleg", "Anna", "Mariya", "Ivan"};
        String[] types = {"Human", "Student", "Teacher", "Employee", "Driver"};
        String[] versions = {"1.1", "2.1", "1.3", "2.2", "4"};

        int numberOfElements;

        System.out.println("Input number of elements: ");
        try {
            numberOfElements = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Try to write whole number.\n" + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("Some problems with input.\n" + e.getMessage());
            return;
        }

        myCollection = new HashSet<>((int) (numberOfElements * 1.5));

        for (int i = 0; i < numberOfElements; i++) {
            myCollection.add(new PlainOldJavaObject(getName(names), getType(types), getVersion(versions)));
        }
    }

    private String getName(String[] names) {
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    private String getType(String[] types) {
        Random random = new Random();
        return types[random.nextInt(types.length)];
    }

    private String getVersion(String[] versions) {
        Random random = new Random();
        return versions[random.nextInt(versions.length)];
    }

    public void fillCollectionManually() {
        int numberOfElements;

        System.out.println("Input number of elements: ");
        try {
            numberOfElements = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Try to write whole number.\n" + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("Some problems with input.\n" + e.getMessage());
            return;
        }

        myCollection = new HashSet<>((int) (numberOfElements * 1.5));

        for (int i = 0; i < numberOfElements; i++) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the name: ");
            String name = scanner.nextLine();

            System.out.println("Enter the type: ");
            String type = scanner.nextLine();

            System.out.println("Enter the version: ");
            String version = scanner.nextLine();

            myCollection.add(new PlainOldJavaObject(name, type, version));
        }
    }

    public void getUniqueByNameType() {
        Iterator<PlainOldJavaObject> iteratorOuter = myCollection.iterator();

        while (iteratorOuter.hasNext()) {
            PlainOldJavaObject pojoOuter = iteratorOuter.next();

            for (PlainOldJavaObject pojoInner : myCollection) {
                if (pojoInner == pojoOuter) continue;
                if (pojoOuter.getName().equals(pojoInner.getName())
                        && pojoOuter.getType().equals(pojoInner.getType())) {
                    iteratorOuter.remove();
                    break;
                }
            }
        }
    }

    public void showElements() {
        for (PlainOldJavaObject plainOldJavaObject : myCollection) {
            System.out.println(plainOldJavaObject);
        }
    }
}
