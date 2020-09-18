package com.paul.sem2.lab1;

import com.paul.sem2.lab1.thread.JavaFileSearcher;

import java.io.File;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DirectoryAnalyser {
    private File startDirectory;
    private Queue<String> javaFiles;
    private ExecutorService executorService;
    public static VersatileCounter vc;

    public DirectoryAnalyser(File startDirectory) {
        vc = new VersatileCounter(0);
        this.startDirectory = startDirectory;
        executorService = Executors.newCachedThreadPool();
        javaFiles = new ConcurrentLinkedQueue<>();
    }

    public Queue<String> searchJavaFiles() {
        executorService.submit(new JavaFileSearcher(startDirectory, javaFiles, executorService));
        vc.await();
        executorService.shutdown();
        return javaFiles;
    }
}
