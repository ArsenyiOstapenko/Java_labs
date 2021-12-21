import java.util.Scanner;

public class CalculatorThread extends Thread {

    private double result = 1;


    Scanner scanner = new Scanner(System.in);

    int a = scanner.nextInt();



    public CalculatorThread(int result) {
    }

    public double getResult() {
        for (int i = 1; i <= a; i++) {
            if (i % 2 == 0) {
                result *= i;
            }

        }
        return result;
    }

}


