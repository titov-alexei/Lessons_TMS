package Leeson7;

import Leeson7.Homework7.Java.Book;
import Leeson7.Homework7.Java.Month;

import java.util.Scanner;

public class Lesson7 {

    public static void main(String[] args) {
//        Person person = new Person("Alex", 33);
//        Person person1 = new Person("Alex", 33);
        //Перменнные хранят ссылки на объекты
//        person.getAge();

//        BankAccount account = new BankAccount("12345678", 100);
//        account.withdrawMoney(50);
//        System.out.println(account.getBalance());
//        account.topUpBalance(15);
//        System.out.println(account.getBalance());

//        Cat lari = new Cat();
//        lari.makeSound();
//        BankAccount account = new BankAccount("123", 100);
//        BankAccount account1 = new BankAccount("123", 100);
//        //BankAccount.test();  //static метод класса
//        System.out.println(account);
//        System.out.println(account1);
//
//        System.out.println(account.equals(account1));
//
//        String hello = "hello";
//        String helloNumTwo = "hello";
//        String str = new String("false");
//        System.out.println(hello.equals(str));


        //Задание №1. Работа с классами и методами
        System.out.println("Задание №1.");
        Book bookIsland = new Book("Остров сокровищ", "Стивенсон", 1883);
        bookIsland.getAboutBook();
        Book bookPushkin = new Book("Сказка о рыбаке и рыбке", "Пушкин", 1820);
        Book bookPushkin2 = new Book("Сказка о рыбаке и рыбке", "Пушкин", 1830);
        System.out.println("Результат сравнения : " + bookPushkin.equals(bookPushkin2));

        isWinter();  //Задание №2. Определение зимнего месяца

    }

    private static void isWinter() {
        //Задание №2. Использование перечислений (enum)
        System.out.println("\nЗадание №2. Определение зимних месяцев. Введите месяц:");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine().toUpperCase();

        if (str.equals(Month.DECEMBER.name()) ||
                str.equals(Month.JANUARY.name()) ||
                    str.equals(Month.FEBRUARY.name()) ||
                        str.toLowerCase().equals(Month.DECEMBER.value) ||
                            str.toLowerCase().equals(Month.JANUARY.value) ||
                                str.toLowerCase().equals(Month.FEBRUARY.value)) {
            System.out.println("Вы ввели зимний месяц");
        } else {
            System.out.println("Это не зимний месяц");
        }
    }
}
