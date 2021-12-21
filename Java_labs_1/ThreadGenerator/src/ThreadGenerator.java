import java.util.Scanner;

public class ThreadGenerator {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите количество потоков: ");
        Scanner scanner = new Scanner(System.in);
        int col = scanner.nextInt();
        System.out.println(col);
        int[] flows = new int[col];
        int[] end = new int[col];
        double[] result = new double[col];
        for (int i = 1; i <= col; i++) {
            System.out.println("Выберите операцию для " + i + " потока\n1.Сложение\n2.Вычитание\n3.Умножение");
            try {
                int operation = scanner.nextInt();
                flows[i - 1] = operation;
                if (flows[i - 1] <= 0)
                    throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!"); // Исключение для отрицательных чисел

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Введите значение a для потока/потоков (где a крайнее число для вычисления произведения четных чисел): ");

        for (int i = 1; i <= col; i++) {

            execute(col, end, result);
            getResult(result, col, flows);
        }

    }

    private static double[] execute(int col, int[] end, double[] result) {
        for (int i = 0; i < col; i++) {
            CalculatorThread calculatorThread = new CalculatorThread(end[i]);
            calculatorThread.start();
            result[i] = calculatorThread.getResult();
            System.out.println("Поток равен: " + result[i]);


        }


        return result;
    }

    private static void getResult(double[] result, int col, int[] flows) {
        int fullResult = 0;
        for (int i = 0; i < col; i++) {
            switch (flows[i]) {
                case 1:
                    fullResult += result[i];
                    break;
                case 2:
                    fullResult -= result[i];
                    break;
                case 3:
                    fullResult *= result[i];
            }

        }
        System.out.println("Итоговый результат решения задачи: " + fullResult);

    }
}


