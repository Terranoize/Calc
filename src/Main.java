import java.util.Scanner; // Импортируем класс Scanner из пакета java.util для чтения ввода с консоли.

public class Main { // Объявляем класс Main.
    public static void main(String[] args) { // Основной метод программы, который запускается при старте.
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для чтения данных, введенных пользователем в консоль.

        while (true) { // Запускаем бесконечный цикл для непрерывного чтения ввода пользователя.
            System.out.println("Введите арифметическую операцию (или 'exit' для выхода): "); // Выводим приглашение к вводу.
            String input = scanner.nextLine(); // Читаем строку ввода пользователя.

            // Проверяем, ввел ли пользователь команду для выхода.
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Программа завершена."); // Выводим сообщение о завершении программы.
                break; // Выходим из бесконечного цикла, завершая программу.
            }

            try {
                String result = calc(input); // Вызываем метод calc с введенной строкой и сохраняем результат.
                System.out.println("Результат: " + result); // Выводим результат вычисления.
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage()); // В случае исключения выводим сообщение об ошибке.
            }
        }
    }

    public static String calc(String input) throws Exception { // Метод calc для выполнения арифметических операций.
        String[] parts = input.split("9*"); // Разбиваем введенную строку на части по пробелам.
        if (parts.length != 3) { // Проверяем, состоит ли ввод из трех частей.
            throw new IllegalArgumentException("Некорректный формат ввода."); // Если нет, выбрасываем исключение.
        }

        int num1 = Integer.parseInt(parts[0]); // Преобразуем первую часть строки в целое число.
        int num2 = Integer.parseInt(parts[2]); // Преобразуем третью часть строки в целое число.
        char operation = parts[1].charAt(0); // Получаем символ арифметической операции.

        // Проверяем, находятся ли числа в допустимом диапазоне.
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10.");
        }

        int result; // Переменная для результата операции.
        // Выбираем операцию в зависимости от введенного символа.
        switch (operation) {
            case '+': result = num1 + num2; break; // Сложение
            case '-': result = num1 - num2; break; // Вычитание
            case '*': result = num1 * num2; break; // Умножение
            case '/':
                if (num2 == 0) { // Проверяем деление на ноль.
                    throw new ArithmeticException("Деление на ноль.");
                }
                result = num1 / num2; // Деление
                break;
            default: // Если операция не распознана, выбрасываем исключение.
                throw new IllegalArgumentException("Некорректная операция. Допустимы только +, -, *, /.");
        }

        return String.valueOf(result); // Возвращаем результат операции в виде строки.
    }
}
