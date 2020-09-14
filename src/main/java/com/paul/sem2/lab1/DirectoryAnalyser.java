package com.paul.sem2.lab1;

import com.paul.sem2.lab1.thread.JavaFileSearcher;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DirectoryAnalyser {
    private File startDirectory;
    private List<String> javaFiles;
    private ExecutorService executorService;
    public final static int THREADS_COUNT = 8;
    public static VersatileCounter vc;

    public DirectoryAnalyser(File startDirectory) {
        vc = new VersatileCounter(0);
        this.startDirectory = startDirectory;
        executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        javaFiles = new CopyOnWriteArrayList<>();
    }

    public List<String> searchJavaFiles() {
        executorService.submit(new JavaFileSearcher(startDirectory, javaFiles, executorService));
        while(!vc.compare(0));
        executorService.shutdown();
        return javaFiles;
    }
}
