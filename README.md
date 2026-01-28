# ⚡ FastScan: Multithreaded File Indexer

**FastScan** is a high-performance **file indexing and directory crawling tool** developed in **Java**. It leverages the power of the **ForkJoinPool** framework to scan file systems in parallel, enabling extremely fast searches across large and deeply nested directory structures.

This project is designed as a **concurrency-focused portfolio project**, showcasing modern Java multithreading techniques and efficient parallel computation.

---

## ✨ Key Features

* **🚀 Parallel Processing**
  Uses `ForkJoinPool` and `RecursiveAction` to scan multiple subdirectories simultaneously across available CPU cores.

* **🔍 Smart File Indexing**
  Filters and lists files based on user-defined extensions such as `.java`, `.pdf`, or `.json`.

* **⚙️ Performance-Oriented Design**
  Efficiently handles deep and large directory trees without the overhead of manual thread management.

* **🧵 Modern Java Concurrency**
  Demonstrates advanced usage of the `java.util.concurrent` package.

---

## 🛠️ Tech Stack

* **Language:** Java 17
* **Concurrency:** ForkJoinPool, RecursiveAction
* **Build Tool:** Maven
* **Core Concepts:**

  * Recursion
  * Multithreading
  * File I/O
  * Parallel Computing

---

## 📥 Installation & Usage

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Enes-Turan/FastScan-Multithreaded-Indexer.git
cd FastScan-Multithreaded-Indexer
```

### 2️⃣ Build the Project

```bash
mvn clean install
```

### 3️⃣ Run the Application

```bash
java -cp target/FastScan-1.0-SNAPSHOT.jar org.example.CrawlerApp
```

---

## 🎮 How It Works

When the application starts, it prompts the user for the following inputs:

* **📁 Target Directory**
  The root path from which the scan begins.
  *Example:* `/Users/enesturan/Desktop`

* **📄 File Extension**
  The file type to search for.
  *Example:* `.java`

### 🔄 Execution Flow

1. The root directory is submitted to a `ForkJoinPool`.
2. Each subdirectory is processed as a separate `RecursiveAction` task.
3. Tasks are split recursively and executed in parallel.
4. Results are joined after completion.
5. The total execution time is printed in **milliseconds**.

---

## 📌 Example Output

```text
Scanning started...
Target directory: /Users/enesturan/Desktop
Searching for: .java

Found 128 files
Completed in 42 ms
```

---

## 🎯 Project Goals

* Understand **Fork/Join parallelism** in Java
* Build a **high-performance file system crawler**
* Apply **recursive task decomposition**
* Create a **clean, interview-ready concurrency project**

---
👨‍💻 Developed by **Enes Turan**
