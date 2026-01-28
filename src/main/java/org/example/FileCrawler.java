package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FileCrawler {
    private final List<String> foundFiles = new ArrayList<>();

    public void scanDirectory(File directory, String searchKey) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ScanTask(directory, searchKey));
    }

    private class ScanTask extends RecursiveAction {
        private final File dir;
        private final String searchKey;

        ScanTask(File dir, String searchKey) {
            this.dir = dir;
            this.searchKey = searchKey;
        }

        @Override
        protected void compute() {
            File[] files = dir.listFiles();
            if (files == null) return;

            List<ScanTask> subTasks = new ArrayList<>();
            for (File file : files) {
                if (file.isDirectory()) {
                    ScanTask task = new ScanTask(file, searchKey);
                    task.fork();
                    subTasks.add(task);
                } else if (file.getName().toLowerCase().contains(searchKey.toLowerCase())) {
                    synchronized (foundFiles) {
                        foundFiles.add(file.getAbsolutePath());
                    }
                }
            }
            for (ScanTask task : subTasks) {
                task.join();
            }
        }
    }

    public List<String> getResults() {
        return foundFiles;
    }
}