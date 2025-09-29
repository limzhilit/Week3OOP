package ie.atu;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        while(true){
            UserInput userInput = getUserInput();

            //perform arithmatics
            Calculator calculator = new Calculator();
            boolean zeroError = false;
            boolean quit  = false;
            double result = switch (userInput.operation) {
                case "add" -> calculator.add(userInput.firstNum, userInput.secondNum);
                case "subtract" -> calculator.sub(userInput.firstNum, userInput.secondNum);
                case "multiply" -> calculator.mul(userInput.firstNum, userInput.secondNum);
                case "divide" -> {
                    if (userInput.secondNum == 0) {
                        zeroError = true;
                        yield 0;
                    }
                    yield calculator.div(userInput.firstNum, userInput.secondNum);
                }
                case "quit" -> {
                    quit = true;
                    yield 0;
                }
                default -> throw new IllegalArgumentException("Invalid operation");

            };

            if (quit) {
                break;
            }
            // print result
            if (zeroError){
                System.out.println("Cannot divide by 0");
                zeroError = false;

            } else {
                System.out.println("The result is: " + result);
            }
        }



    }

    public record UserInput(String operation, int firstNum, int secondNum) {}

    public static UserInput getUserInput() {
        //get user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose the operation (add, subtract, multiply, divide, quit): ");
        String operation = sc.nextLine().trim();
        while (!operation.equals("add") && !operation.equals("subtract") && !operation.equals("multiply") && !operation.equals("divide")  && !operation.equals("quit")) {
            System.out.print("Invalid input, ");
            System.out.print("choose the operation (add, subtract, multiply, divide): ");
            operation = sc.nextLine();
        }

        if (operation.equals("quit")) {
            return new UserInput(operation, 0, 0);
        }

        System.out.println("Insert first number:");
        int firstNum = sc.nextInt();
        System.out.println("Insert second number:");
        int secondNum = sc.nextInt();

        return new UserInput(operation, firstNum, secondNum);
    }
}
