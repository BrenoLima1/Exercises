package javaFiles;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TaskList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        int nextId = 1;

        while (true) {
            System.out.println("\n=== Task List ===");
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Complete task");
            System.out.println("4. Remove task");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    tasks.add(new Task(nextId++, title, desc, new Date()));
                    System.out.println("Task added!");
                    break;
                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks registered.");
                    } else {
                        tasks.forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.print("Enter the task ID to complete: ");
                    int id = sc.nextInt();
                    tasks.stream()
                         .filter(t -> t.getId() == id)
                         .findFirst()
                         .ifPresentOrElse(
                             t -> { t.setCompleted(true); System.out.println("Task completed!"); },
                             () -> System.out.println("ID not found.")
                         );
                    break;
                case 4:
                    System.out.print("Enter the task ID to remove: ");
                    int removeId = sc.nextInt();
                    tasks.removeIf(t -> t.getId() == removeId);
                    System.out.println("Task removed!");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
