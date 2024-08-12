import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove Task");
            System.out.println("5. Sort Tasks by Priority");
            System.out.println("6. Sort Tasks by Due Date");
            System.out.println("7. Save Tasks");
            System.out.println("8. Load Tasks");
            System.out.println("9. Exit");

            int choice = getValidIntInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    System.out.println("Adding a New Task");
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    int priority = getValidIntInput(scanner, "Enter priority (1-10): ");

                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    LocalDate dueDate = null;
                    while (dueDate == null) {
                        try {
                            dueDate = LocalDate.parse(scanner.next());
                        } catch (Exception e) {
                            System.out.print("Invalid date format. Please enter a date in YYYY-MM-DD format: ");
                        }
                    }

                    toDoList.addTask(new Task(title, description, priority, dueDate));
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    System.out.println("\nTasks:");
                    if (toDoList.getTasks().isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (Task task : toDoList.getTasks()) {
                            System.out.println(task);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the task to mark as completed: ");
                    title = scanner.nextLine();
                    toDoList.markTaskAsCompleted(title);
                    System.out.println("Task marked as completed.");
                    break;
                case 4:
                    System.out.print("Enter the title of the task to remove: ");
                    title = scanner.nextLine();
                    Task task = toDoList.findTaskByTitle(title);
                    if (task != null) {
                        toDoList.removeTask(task);
                        System.out.println("Task removed successfully.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 5:
                    toDoList.sortTasksByPriority();
                    System.out.println("Tasks sorted by priority.");
                    break;
                case 6:
                    toDoList.sortTasksByDueDate();
                    System.out.println("Tasks sorted by due date.");
                    break;
                case 7:
                    try {
                        toDoList.saveTasksToFile("tasks.dat");
                        System.out.println("Tasks saved to file.");
                    } catch (IOException e) {
                        System.out.println("Failed to save tasks: " + e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        toDoList.loadTasksFromFile("tasks.dat");
                        System.out.println("Tasks loaded from file.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Failed to load tasks: " + e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        }
    }

    private static int getValidIntInput(Scanner scanner, String prompt) {
        int input = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character
        return input;
    }
}
