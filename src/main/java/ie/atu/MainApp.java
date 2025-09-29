package ie.atu;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        //get user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert first number:");
        int firstNum = sc.nextInt();
        System.out.println("Insert second number:");
        int secondNum = sc.nextInt();

        //perform arithmatics
        Calculator calculator = new Calculator();
        int result = calculator.add(firstNum, secondNum);


        // print result
        System.out.println("The result is: " + result);

    }
}
