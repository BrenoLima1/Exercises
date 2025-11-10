
import DAO.UserDAO;
import entities.User;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to register, delete, update, find a user or find all users?");

        System.out.println("1 - Register");
        System.out.println("2 - Delete");
        System.out.println("3 - Update");
        System.out.println("4 - Find");
        System.out.println("5 - Find All");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            System.out.println("Register:");
            System.out.print("Name: "); String name = sc.nextLine();
            System.out.print("Login: "); String login = sc.next(); sc.nextLine();
            System.out.print("Password: "); String password = sc.nextLine();
            System.out.print("Email: "); String email = sc.nextLine();

            User user = new User(
                name,
                login,
                password,
                email
            );

            userDAO.registerUser(user);
        }else if (op == 2) {
            System.out.println("Delete:");
            System.out.print("User's ID: "); int code = sc.nextInt();
            userDAO.deleteUser(code);
        }else if (op == 3) {
            System.out.println("Update:");
            System.out.print("User's ID: "); int userID = sc.nextInt(); sc.nextLine();

            User user = userDAO.findUser(userID);
            if (user == null) {
                System.out.println("User not found.");
                return;
            }

            System.out.print("Name: "); String name = sc.nextLine();
            System.out.print("Login: "); String login = sc.nextLine();
            System.out.print("Password: "); String password = sc.nextLine();
            System.out.print("Email: "); String email = sc.nextLine();

            User updatedUser = new User(
                name,
                login,
                password,
                email
            );

            boolean success = userDAO.updateUser(userID, updatedUser);
            if(success){
                System.out.println("User updated successfully.");
            }else{
                System.out.println("Update failed :(");
            }

        }else if (op == 4) {
            System.out.println("Find:");
            System.out.print("User's ID: "); int userID = sc.nextInt();
            User user = userDAO.findUser(userID);
            System.out.println(user);
        }else if (op == 5) {
            System.out.println("Find All:");
            User[] users = userDAO.findAllUsers();
            for (User user : users) {
                System.out.println(user);
            }
        }

        sc.close();
    }
}
