package ie.atu;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        while(true){
            UserInput userInput = getUserInput();

            //perform arithmetic
            Calculator calculator = new Calculator();
            boolean zeroError = false;
            boolean quit  = false;
            double result = switch (userInput.operation) {
                case 1 -> calculator.add(userInput.firstNum, userInput.secondNum);
                case 2 -> calculator.sub(userInput.firstNum, userInput.secondNum);
                case 3 -> calculator.mul(userInput.firstNum, userInput.secondNum);
                case 4 -> {
                    if (userInput.secondNum == 0) {
                        zeroError = true;
                        yield 0;
                    }
                    yield calculator.div(userInput.firstNum, userInput.secondNum);
                }
                case 5 -> calculator.mod(userInput.firstNum, userInput.secondNum);
                case 0 -> {
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
                System.out.println("The result is: " + result + "\n");
            }
        }



    }

    public record UserInput(int operation, int firstNum, int secondNum) {}

    public static UserInput getUserInput() {
        //get user input
        Scanner sc = new Scanner(System.in);
        String menu = """
                (1) add     (2) subtract    (3) multiply
                (4) divide  (5) modulo      (0) quit
                Enter the operation (0-5): 
                """;
        System.out.print(menu);
        int operation = sc.nextInt();
        while (operation > 6 || operation < 0) {
            System.out.print("Enter operation ");
            operation = sc.nextInt();
        }

        if (operation == 0) {
            return new UserInput(operation, 0, 0);
        }

        System.out.println("Insert first number:");
        int firstNum = sc.nextInt();
        System.out.println("Insert second number:");
        int secondNum = sc.nextInt();

        return new UserInput(operation, firstNum, secondNum);
    }
}
