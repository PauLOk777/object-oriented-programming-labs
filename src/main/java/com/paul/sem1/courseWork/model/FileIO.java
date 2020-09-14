package com.paul.sem1.courseWork.model;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
