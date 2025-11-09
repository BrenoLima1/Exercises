
import java.util.Scanner;

public class Calculator {

   public double add(double a, double b) {
    return a + b;
}

public double subtract(double a, double b) {
    return a - b;
}

public double multiply(double a, double b) {
    return a * b;
}

public double divide(double a, double b) {
    if (b == 0) {
        throw new ArithmeticException("Division by zero is not allowed");
    }
    return a / b;
}

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Calculator! You can use any number!");
        System.out.println("Choose operation (+, -, *, /):");
        char operator = sc.next().charAt(0);
        System.out.println("First number: ");
        double firstNumber = sc.nextDouble();
        System.out.println("Second number: ");
        double secondNumber = sc.nextDouble();

        switch (operator) {
            case '+':
                System.out.println("Result: " + calculator.add(firstNumber, secondNumber));
                break;
            case '-':
                System.out.println("Result: " + calculator.subtract(firstNumber, secondNumber));
                break;
            case '*':
                System.out.println("Result: " + calculator.multiply(firstNumber, secondNumber));
                break;
            case '/':
                System.out.println("Result: " + calculator.divide(firstNumber, secondNumber));
                break;
            default:
                System.out.println("Invalid operator");
        }
    }
}
