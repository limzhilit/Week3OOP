package ie.atu;

public class Calculator {

    public Calculator() {
    }

    public int add(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    public int sub(int firstNum, int secondNum) {return firstNum - secondNum;}

    public int mul(int firstNum, int secondNum) {return firstNum * secondNum;}

    public int div(int firstNum, int secondNum) {
        if (secondNum == 0) {
            throw new IllegalArgumentException("Division by zero!");
        }
        return firstNum / secondNum;}

}
