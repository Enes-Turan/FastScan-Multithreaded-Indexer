# ⚡ FastScan: Multithreaded Global File Indexer

FastScan is a high-performance directory crawling and file indexing tool developed in Java. By utilizing the **ForkJoinPool** framework, it processes file systems in parallel, allowing for lightning-fast searches across thousands of directories.

## ✨ New Features
* **Global Search (Contains):** Searches for keywords across both filenames and extensions using case-insensitive matching.
* **Full-Scale Crawling:** Capable of scanning everything from a single folder to the entire root directory (`/`).
* **Clean & Optimized:** Refined codebase with all redundant code and debug comments removed for production-level quality.

## 🛠️ Tech Stack
* **Language:** Java
* **Concurrency:** ForkJoinPool, RecursiveAction (Fork-Join Architecture)
* **Build Tool:** Maven
* **Core Concepts:** Recursion, Multithreading, Parallel Computing, Performance Optimization

## 📖 How It Works
When you run the application, it prompts for:
1. **Target Directory:** The root path to start the scan (e.g., `/Users/enesturan/Downloads` or `/`).
2. **Search Key:** The specific keyword or extension you are looking for (e.g., `Task`, `.pdf`, `project`).

The engine then splits the work into sub-tasks, processes them across multiple CPU cores, and reports every matching file path.

## 👨‍💻 Author
**Enes Turan** - Third-year Software Engineering Student at Kırklareli University.
