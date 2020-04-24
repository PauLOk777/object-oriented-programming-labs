package com.paul.lab1.model;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class FileIO {
    static Elective[] readElectivesJSON(String filePath) throws IOException {
        Gson gson = new Gson();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        StringBuilder electivesStr = new StringBuilder();
        byte byteData;

        while ((byteData = (byte)bis.read()) != -1) {
            electivesStr.append((char)byteData);
        }

        bis.close();
        return gson.fromJson(electivesStr.toString(), Elective[].class);
    }

    static void writeBooksToFile (Elective[] electives, String filePath) throws IOException {
        Gson gson = new Gson();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        String electivesStr = gson.toJson(electives);
        bos.write(electivesStr.getBytes());
        bos.close();
    }
}
