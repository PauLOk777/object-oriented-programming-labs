package com.paul.sem2.lab1.thread;

import com.paul.sem2.lab1.DirectoryAnalyser;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class JavaFileSearcher implements Runnable {
    private File currentDirectory;
    private List<String> javaFiles;
    private ExecutorService executorService;
    public final static String EXPANSION = "java";

    public JavaFileSearcher(File currentDirectory, List<String> javaFiles, ExecutorService executorService) {
        DirectoryAnalyser.vc.increment();
        this.currentDirectory = currentDirectory;
        this.javaFiles = javaFiles;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        File[] files = currentDirectory.listFiles();
        if (files == null) {
            DirectoryAnalyser.vc.decrementAndNotifyIfZero();
            return;
        }
        for (File file: files) {
            String[] partOfName = file.getName().split("\\.");
            if (file.isDirectory()) {
                executorService.submit(new JavaFileSearcher(file, javaFiles, executorService));
            } else if (EXPANSION.equals(partOfName[partOfName.length - 1])) {
                javaFiles.add(file.getAbsolutePath());
                executorService.submit(new JavaFileModifier(file));
            }
        }
        DirectoryAnalyser.vc.decrementAndNotifyIfZero();
    }
}
