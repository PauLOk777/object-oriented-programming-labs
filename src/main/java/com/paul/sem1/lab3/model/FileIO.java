package com.paul.sem1.lab3.model;

import com.google.gson.Gson;

import java.io.*;

class FileIO {
    static Elective[] readElectivesJSON(String filePath) throws IOException {
        Gson gson = new Gson();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            StringBuilder electivesStr = new StringBuilder();
            byte byteData;

            while ((byteData = (byte)bis.read()) != -1) {
                electivesStr.append((char)byteData);
            }

            return gson.fromJson(electivesStr.toString(), Elective[].class);
        }
    }

    static void writeElectivesToTXT(String electives, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))){
            bos.write(electives.getBytes());
        }
    }
}
