import DAO.UserDAO;
import entities.User;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== User Management ===");
            System.out.println("1 - Register");
            System.out.println("2 - Delete");
            System.out.println("3 - Update");
            System.out.println("4 - Find");
            System.out.println("5 - Find All");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");

            int op;
            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            if (op == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (op) {
                case 1 -> {
                    System.out.println("Register:");
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Login: "); String login = sc.nextLine();
                    System.out.print("Password: "); String password = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();

                    User user = new User(name, login, password, email);
                    boolean success = userDAO.registerUser(user);
                    System.out.println(success ? "User registered successfully." : "Registration failed.");
                }
                case 2 -> {
                    System.out.println("Delete:");
                    System.out.print("User's ID: ");
                    int code = Integer.parseInt(sc.nextLine());
                    boolean success = userDAO.deleteUser(code);
                    System.out.println(success ? "User deleted successfully." : "User not found.");
                }
                case 3 -> {
                    System.out.println("Update:");
                    System.out.print("User's ID: ");
                    int userID = Integer.parseInt(sc.nextLine());

                    User existingUser = userDAO.findUser(userID);
                    if (existingUser == null) {
                        System.out.println("User not found.");
                        continue;
                    }

                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Login: "); String login = sc.nextLine();
                    System.out.print("Password: "); String password = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();

                    User updatedUser = new User(name, login, password, email);
                    boolean success = userDAO.updateUser(userID, updatedUser);
                    System.out.println(success ? "User updated successfully." : "Update failed.");
                }
                case 4 -> {
                    System.out.println("Find:");
                    System.out.print("User's ID: ");
                    int userID = Integer.parseInt(sc.nextLine());
                    User user = userDAO.findUser(userID);
                    System.out.println(user != null ? user : "User not found.");
                }
                case 5 -> {
                    System.out.println("Find All:");
                    List<User> users = userDAO.findAllUsers();
                    if (users.isEmpty()) {
                        System.out.println("No users found.");
                    } else {
                        users.forEach(System.out::println);
                    }
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
}
