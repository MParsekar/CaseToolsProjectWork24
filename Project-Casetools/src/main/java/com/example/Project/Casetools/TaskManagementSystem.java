package main.java.com.example.Project.Casetools;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManagementSystem {
    private List<Task> tasks;
    private static final int ADD_TASK = 1;
    private static final int MARK_TASK_COMPLETED = 2;
    private static final int LIST_ALL_TASKS = 3;
    private static final int EXIT = 4;

    public TaskManagementSystem() {
        this.tasks = new ArrayList<>();
    }

    static class Task {
        private String name;
        private String assignedTo;
        private boolean completed;

        public Task(String name, String assignedTo) {
            this.name = name;
            this.assignedTo = assignedTo;
            this.completed = false;
        }

        // Getters and setters for the Task class
    }

    public void addTask(String name, String assignedTo) {
        tasks.add(new Task(name, assignedTo));
        System.out.println("Task added successfully!");
    }

    public void markTaskAsCompleted(String taskName) {
        for (Task task : tasks) {
            if (task.name.equalsIgnoreCase(taskName)) { // Access the 'name' field directly
                task.completed = true;
                System.out.println("Task marked as completed!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    public void listAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
            return;
        }
        System.out.println("All tasks:");
        for (Task task : tasks) {
            System.out.println("Name: " + task.name + ", Assigned To: " + task.assignedTo + ", Completed: " + task.completed);
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem taskManager = new TaskManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTask Management System");
            System.out.println(ADD_TASK + ". Add Task");
            System.out.println(MARK_TASK_COMPLETED + ". Mark Task as Completed");
            System.out.println(LIST_ALL_TASKS + ". List All Tasks");
            System.out.println(EXIT + ". Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case ADD_TASK:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter assigned to: ");
                    String assignedTo = scanner.nextLine();
                    taskManager.addTask(taskName, assignedTo);
                    break;
                case MARK_TASK_COMPLETED:
                    System.out.print("Enter task name to mark as completed: ");
                    String taskToComplete = scanner.nextLine();
                    taskManager.markTaskAsCompleted(taskToComplete);
                    break;
                case LIST_ALL_TASKS:
                    taskManager.listAllTasks();
                    break;
                case EXIT:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
