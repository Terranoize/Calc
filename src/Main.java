import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите арифметическую операцию (или 'exit' для выхода): ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Программа завершена.");
                break;
            }

            try {
                String result = calc(input);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Некорректный формат ввода.");
        }

        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);
        char operation = parts[1].charAt(0);

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10.");
        }

        int result;
        switch (operation) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Некорректная операция. Допустимы только +, -, *, /.");
        }

        return String.valueOf(result);
    }
}
