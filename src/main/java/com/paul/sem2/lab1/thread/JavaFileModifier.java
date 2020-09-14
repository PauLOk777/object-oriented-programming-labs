package com.paul.sem2.lab1.thread;

import com.paul.sem2.lab1.DirectoryAnalyser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaFileModifier implements Runnable {
    private File file;

    public JavaFileModifier(File file) {
        DirectoryAnalyser.vc.increment();
        this.file = file;
    }

    @Override
    public void run() {
        List<String> lines = getFile();
        modifyLines(lines);
        rewriteFile(lines);
        DirectoryAnalyser.vc.decrement();
    }

    private List<String> getFile() {
        List<String> content = new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(file);
                Scanner scanner = new Scanner(fis)) {
            while(scanner.hasNextLine())
                content.add(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    private void modifyLines(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String trimLine = lines.get(i).trim();
            lines.set(i, trimLine.replaceAll(" {2,}", " "));
        }
    }

    private void rewriteFile(List<String> lines) {
        try(FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            StringBuilder sb = new StringBuilder();
            for (String line: lines) {
                sb.append(line).append('\n');
            }
            byte[] buffer = sb.toString().getBytes();
            bos.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
