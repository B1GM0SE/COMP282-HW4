# How to Run the Assignment Code

This project includes two helper scripts:

- `run.sh` – for **macOS / Linux**
- `run.bat` – for **Windows**

These scripts:
- **compile** all `.java` files
- **run** one of the driver programs:
  - `CSLinkedListDriver` (linked list tasks)
  - `ListStackDriver` (stack tasks)
  - `ArrayQueueDriver` (queue tasks)

---

## 1. On macOS or Linux (using `run.sh`)

### Step 1: Open a terminal in the project folder

1. Save or clone the assignment folder to your computer.
2. Open **Terminal**.
3. Navigate to the folder containing the `.java` files and `run.sh`. For example:

```bash
cd ~/Downloads/ds_assignment_starter
```

To check that you are in the right place, type:

```bash
ls
```

You should see files like:

- `CSLinkedList.java`
- `CSLinkedListDriver.java`
- `ListStack.java`
- `ListStackDriver.java`
- `StackInt.java`
- `ArrayQueue.java`
- `ArrayQueueDriver.java`
- `run.sh`
- `run.bat`

### Step 2: Make the script executable (first time only)

```bash
chmod +x run.sh
```

If it succeeds, it prints nothing (that’s normal).

### Step 3: Run the script

Choose one of the following commands:

```bash
./run.sh list    # compile and run CSLinkedListDriver
./run.sh stack   # compile and run ListStackDriver
./run.sh queue   # compile and run ArrayQueueDriver
./run.sh all     # run all three drivers in sequence
```

> Note: If nothing seems to happen, make sure you have **uncommented** the method call
> for your task inside the correct `main` method (e.g., `runLL3_CourseWaitlist();`).

---

## 2. On Windows (using `run.bat`)

### Step 1: Open Command Prompt in the project folder

1. Save or clone the assignment folder.
2. Open **Command Prompt**.
3. Navigate to the folder that contains the `.java` files and `run.bat`. For example:

```bat
cd %HOMEPATH%\Downloads\ds_assignment_starter
```

To check, type:

```bat
dir
```

You should see the same list of `.java` files plus `run.sh` and `run.bat`.

### Step 2: Run the script

Use one of these commands:

```bat
run list   
run stack  
run queue  
run all    
```

They do the following:

- `run list`  → compile and run `CSLinkedListDriver`
- `run stack` → compile and run `ListStackDriver`
- `run queue` → compile and run `ArrayQueueDriver`
- `run all`   → run all three, one after another

---

## 3. Before You Run: Choose Your Task

In each driver file, the `main` method has a list of commented-out method calls.  
For example, in `CSLinkedListDriver.java`:

```java
public static void main(String[] args) {
    // TODO: Uncomment EXACTLY ONE of the following lines,
    // then implement that method below.

    //runLL1_Playlist();
    //runLL2_TodoList();
    //runLL3_CourseWaitlist();
    // ...
}
```

To work on **your** assigned task:

1. **Uncomment** the line for your task (remove `//` at the beginning).
2. Implement the corresponding method below.

Example for a student assigned **LL3**:

```java
public static void main(String[] args) {
    runLL3_CourseWaitlist();
}
```

Then run the appropriate script:

- On macOS/Linux: `./run.sh list`
- On Windows: `run list`

---

## 4. If You Get Errors

- `javac: command not found`  
  → Java is not installed or not on your PATH. Install a JDK and try again.

- `Error: Could not find or load main class ...`  
  → Check for compile errors above that message, or make sure you’re in the correct folder.

- No output appears after running a script  
  → Make sure you have uncommented the correct `runXX_...()` method in `main`
    and that your method prints something.

If you are stuck, take a screenshot or copy the exact error message and ask your instructor or TA.
