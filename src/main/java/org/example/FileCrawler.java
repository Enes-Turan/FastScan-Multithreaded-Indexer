package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FileCrawler {
    private final List<String> foundFiles = new ArrayList<>();

    public void scanDirectory(File directory, String extension) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ScanTask(directory, extension));
    }

    private class ScanTask extends RecursiveAction {
        private final File dir;
        private final String ext;

        ScanTask(File dir, String ext) {
            this.dir = dir;
            this.ext = ext;
        }

        @Override
        protected void compute() {
            File[] files = dir.listFiles();
            if (files == null) return;

            List<ScanTask> subTasks = new ArrayList<>();
            for (File file : files) {
                if (file.isDirectory()) {
                    ScanTask task = new ScanTask(file, ext);
                    task.fork();
                    subTasks.add(task);
                } else if (file.getName().toLowerCase().endsWith(ext.toLowerCase())) {
                    synchronized (foundFiles) {
                        foundFiles.add(file.getAbsolutePath());
                    }
                }
            }
            for (ScanTask task : subTasks) task.join();
        }
    }

    public List<String> getResults() {
        return foundFiles;
    }
}