package Lesson10;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ariphmeticOperation(9, 0);  //Задание 1. Деление на ноль (ArithmeticException)
        System.out.println("Element = " + getElement()); // Задание №2. Выход за границы массива (ArrayIndexOutOfBoundsException)
        nullObject(); //Задача 3. Обработка NullPointerException
        getNumber(); //Задание №4. Обработка NumberFormatException
        openNotFoundFile(); //Задача 5. Исключение при работе с файлами. Открыть несуществующий файл и обработать ошибку
        divZeroAndOutOfBounds(5, 0); //Задача №6. Вложенные try-catch.

        //Задание №7. Кастомное исключение (CustomException)
        try {
            System.out.println("Задание №7. Кастомное исключение (CustomException)");
            customException(-1);
        } catch (CustomException e) {
            System.out.println("Перехваченное сообщение " + e);
        }


        readScanner(); //Задача 8: Использование finally для закрытия ресурсов
        controlEnterCommand(); //Задача 9: Система ввода команд с контролем ошибок"

        /*
        Задача 10: Рекурсивный вызов с контролем глубины
         */

        System.out.println("Задача 10: Рекурсивный вызов с контролем глубины. Введите глубину:");
        try {
            int numberDepth = scanner.nextInt();
            try {
                System.out.println(controlDepth(Math.abs(numberDepth)));
            } catch (StackOverflowError error) {
                error.printStackTrace();
                System.out.println("Превышен стэк значения глубины");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Введите целое число");
        }


            checkAge(); //Задание №11. Проверка корректности входных данных. Запросить у пользователя возвраст и проверить

    }

    /*
    Задача 1: Деление на ноль (ArithmeticException)
    Написать программу, которая делит одно число на другое. Обработать исключение, если происходит деление на ноль.
     */
    public static void ariphmeticOperation(int a, int b) {
        System.out.println("Задача 1: Деление на ноль (ArithmeticException)");
        int result;
        try {
            result = a / b;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            result = -1;
        }
        System.out.println("Result = " + result);
    }

    /*
    Задача 2: Выход за границы массива (ArrayIndexOutOfBoundsException)
    Запросить у пользователя индекс массива и вывести элемент. Обработать ситуацию выхода за границы массива.
     */
    public static int getElement() {
        System.out.println("Задача 2: Выход за границы массива (ArrayIndexOutOfBoundsException)");
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Введите индекс:");
        Scanner scanner = new Scanner(System.in);
        try {
            int index = scanner.nextInt();
            return index;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    /*
    Задача 3: Обработка NullPointerException
    Попробовать вызвать метод у null-объекта и обработать NullPointerException.
     */
    public static void nullObject() {
        System.out.println("Задача 3: Обработка NullPointerException");
        Scanner scanner = null;
        try {
            System.out.println("Scanner " + scanner.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Scanner is null");
        }
    }


    /*
    Задача 4: Обработка NumberFormatException
    Преобразовать строку в число и обработать ситуацию, если ввод некорректный.
     */
    public static void getNumber() {
        System.out.println("Введите строковое число:");
        Scanner scan = new Scanner(System.in);
        String stringNumber = scan.nextLine();
        try {
            int intNumber = Integer.parseInt(stringNumber);
            System.out.println("Число " + intNumber);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Неверный ввод");

        }
    }

    /*
    Задача 5: Исключение при работе с файлами (FileNotFoundException)
    Открыть несуществующий файл и обработать ошибку.
     */
    public static void openNotFoundFile() {
        System.out.println("Задача 5: Исключение при работе с файлами (FileNotFoundException)");
        Scanner scanner = null;
        try {
            File file = new File("text.txt");
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Такого файла не существует");
        }
    }

    /*
    Задача 6: Вложенные try-catch
    Обработать исключения на разных уровнях (деление на ноль и выход за границы массива).
     */
    public static void divZeroAndOutOfBounds(int a, int b) {
        System.out.println("Задача 6: Вложенные try-catch. Обработать исключения на разных уровнях (деление на ноль и выход за границы массива).");
        try {
            int result = a / b;
            System.out.println("Результат деления " + result);
            try {
                int[] array = {1, 2, 3, 4};
                array[a] = b;
                System.out.println("Элемент массива array равен " + array[a]);
            } catch (Exception e2) {
                e2.printStackTrace();
                System.out.println("Выход за границы массива");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            System.out.println("Деление на ноль");
        }
    }

    /*
    Задача 7: Кастомное исключение (CustomException)
    Создать свое исключение и бросить его, если число меньше 0.
     */
    public static void customException(int x) throws CustomException {
        System.out.println("Начало метода customException");
        if (x < 0) {
            throw new CustomException(x, "Число меньше нуля");
        }
        System.out.println("Все хорошо завершилось");
    }


    /*
    Задача 8: Использование finally для закрытия ресурсов
    Задача: Открыть файл и закрыть Scanner, используя finally.
     */
    public static void readScanner() {
        Scanner scan = null;
        try {
            File file = new File("text.txt");
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scan != null) scan.close();
            System.out.println("Сканер закрыт");
        }
    }

    /*
    Задача 9: Система ввода команд с контролем ошибок
    Напишите программу, которая запрашивает у пользователя команду (ADD, REMOVE, EXIT). Обработайте исключения,
    если команда нераспознаваема.
    Особенность: Использование кастомного исключения InvalidCommandException.
     */
    public static void controlEnterCommand(){
        System.out.println("Задача 9: Система ввода команд с контролем ошибок");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите команду:");
            String result = scanner.nextLine();
            switch (result) {
                case "ADD" : {
                    System.out.println("Вы ввели команду ADD. Идет добавление...");
                    break;
                }
                case "REMOVE" : {
                    System.out.println("Вы ввели команду REMOVE. Идет удаление...");
                    break;
                }
                case "EXIT" : {
                    System.out.println("Вы ввели команду EXIT. Выходимы!");
                    break;
                }
                default : throw new InvalidCommandException(result);
            }
        } catch (InvalidCommandException e) {
            System.out.println("Ошибка ввода");
            e.printStackTrace();
        }
    }

    /*
    Задача 10: Рекурсивный вызов с контролем глубины
    Написать рекурсивную функцию, которая вызывает саму себя, пока не
    достигнет предела глубины.
    Особенность: Контроль StackOverflowError.
     */
    public static int controlDepth(int depth) {
        if (depth == 0) return 0;
        System.out.println(depth);
        depth--;
        return controlDepth(depth);
    }

    /*
    Задача 11: Проверка корректности входных данных
    Запросить у пользователя возраст и проверить, является ли он числом от 0 до 120.
    Особенность: Использование кастомного исключения InvalidAgeException.
     */
    public static void checkAge(){
        System.out.println("Задача 11: Проверка корректности входных данных. Введите возраст");
        Scanner scanner = new Scanner(System.in);
        try {
            int age = scanner.nextInt();
            if (0 <= age && age <= 120) {
                System.out.println("Возраст равен " + age);
            } else {
                throw new InvalidAgeException(age);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Необходимо ввести положительное целое число от 0 до 120");
        }
    }

}
