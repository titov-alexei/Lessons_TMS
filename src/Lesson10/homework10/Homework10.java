package Lesson10.homework10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework10 {
    public static void main(String[] args) {
        divTwoNumber(); //Задание №1. Деление с обработкой исключения.
        checkAge(); //Задача 2: Проверка возраста (кастомное исключение)
        checkEmptyString(); //Задача 3: Обработка пустой строки
    }


    /*
    Задача 1:Деление с обработкой исключения
    Задача: Написать программу, которая делит два числа, введенных пользователем.
    Обработать: ArithmeticException (деление на ноль). InputMismatchException (если введено не число).
     */
    public static void divTwoNumber() {
        Scanner scanner = new Scanner(System.in);
        //int result = 0;
        try {
            System.out.println("Введите первое число:");
            int x = scanner.nextInt();
            System.out.println("Введите второе число");
            int y = scanner.nextInt();
            int result = x / y;
            System.out.println("Результат деления: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число");
            e.printStackTrace();
        } catch (ArithmeticException exception) {
            System.out.println("Деление на ноль");
            exception.printStackTrace();
        }

    }

    /*
    Задача 2: Проверка возраста (кастомное исключение)
    Задача: Попросить пользователя ввести возраст. Если возраст < 18, выбросить исключение.
    Используем кастомное исключение TooYoungException.
     */
    public static void checkAge() {
        System.out.println("Задача 2: Проверка возраста (кастомное исключение).\nВведите возраст:");
        Scanner scanner = new Scanner(System.in);
        try {
            int age = scanner.nextInt();
            if (age < 18) {
                throw new TooYoungException(age);
            }
            System.out.println("Вы ввели " + age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Задача 3: Обработка пустой строки
    Задача: Запросить у пользователя строку и проверить, что она не пустая.
    Обработать: IllegalArgumentException, если строка пустая.
     */
    public static void checkEmptyString(){
        System.out.println("Задача 3: Обработка пустой строки\nВведите любую строку");
        Scanner scanner = new Scanner(System.in);
        try {
            String str = scanner.nextLine();
            if (str.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
            System.out.println("Вы ввели строку " + str);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }


}
