package ie.atu;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        UserInput userInput = getUserInput();

        //perform arithmatics
        Calculator calculator = new Calculator();
        double result = switch (userInput.operation) {
            case "add" -> calculator.add(userInput.firstNum, userInput.secondNum);
            case "sub" -> calculator.sub(userInput.firstNum, userInput.secondNum);
            default -> throw new IllegalArgumentException("Invalid operation");

        };
        // print result
        System.out.println("The result is: " + result);

    }

    public record UserInput(String operation, int firstNum, int secondNum) {}

    public static UserInput getUserInput() {
        //get user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose the operation (add, subtract, multiply, divide): ");
        String operation = sc.nextLine();
        while (!operation.equals("add") && !operation.equals("subtract") && !operation.equals("multiply") && !operation.equals("divide")) {
            System.out.print("Invalid input, ");
            System.out.print("choose the operation (add, subtract, multiply, divide): ");
            operation = sc.nextLine();
        }

        System.out.println("Insert first number:");
        int firstNum = sc.nextInt();
        System.out.println("Insert second number:");
        int secondNum = sc.nextInt();

        return new UserInput(operation, firstNum, secondNum);
    }
}
