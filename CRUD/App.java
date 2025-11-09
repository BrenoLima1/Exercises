
import DAO.UserDAO;
import entities.User;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
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

            UserDAO userDAO = new UserDAO();
            User user = new User(
                name,
                login,
                password,
                email
            );

            userDAO.registerUser(user);
        }


        sc.close();
    }
}
