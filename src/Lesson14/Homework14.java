package Lesson14;

import java.util.concurrent.atomic.AtomicInteger;

public class Homework14 {

    public static void main(String[] args) throws InterruptedException {
        incrementDecrementWithObject(); //Задача 1: Синхронизация доступа к счетчику с помощью внешнего объекта
        atomicCounter();    //Задача 2: Применение атомарных типов для безопасного увеличения счетчика
        incrementDecrement(); //Задача 3: Синхронизация потоков для предотвращения гонки данных
    }

    /*
    Задача 1: Синхронизация доступа к счетчику с помощью внешнего объекта
    Описание: Вам нужно создать класс Counter, который будет иметь метод increment и
    метод decrement. Эти методы должны увеличивать и уменьшать значение переменной
    count в многопоточном режиме. Для синхронизации доступов используйте внешний
    объект (не объект класса).
     */
    public static void incrementDecrementWithObject() {
        System.out.println("Задача 1: Синхронизация доступа к счетчику с помощью внешнего объекта");
        CounterHW counterHW = new CounterHW();
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counterHW.increment();
                System.out.println(Thread.currentThread().getName() + " " + counterHW.getCounter());
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                counterHW.decrement();
                System.out.println(Thread.currentThread().getName() + " " + counterHW.getCounter());
            }
        });

        threadOne.start();
        threadTwo.start();
    }

    /*
    Задача 2: Применение атомарных типов для безопасного увеличения счетчика
    Описание: Напишите программу, в которой два потока одновременно увеличивают
    счетчик. Вместо синхронизации используйте класс AtomicInteger, чтобы избежать
    блокировок.
     */
    public static void atomicCounter() throws InterruptedException {
        System.out.println("Задача 2: Применение атомарных типов для безопасного увеличения счетчика");
        AtomicInteger number = new AtomicInteger(0);
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                number.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " " + number);
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                number.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " " + number);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(number);
    }

    /*
    Задача 3: Синхронизация потоков для предотвращения гонки данных
    Описание: Напишите программу с двумя потоками, которые одновременно
    увеличивают и уменьшают значение счетчика. Ваша задача — обеспечить, чтобы
    операция увеличения и уменьшения была выполнена безопасно с помощью
    синхронизации.
     */
    public static void incrementDecrement() {
        System.out.println("Задача 3: Синхронизация потоков для предотвращения гонки данных");
        AtomicInteger number = new AtomicInteger(0);
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                number.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " " + number);
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 50; i++) {
                number.decrementAndGet();
                System.out.println(Thread.currentThread().getName() + " " + number);
            }
        });
        thread1.start();
        thread2.start();
        //thread1.join();
        //thread2.join();
        //System.out.println(number);
    }
}

//Класс для задачи 1: Синхронизация через объект
class CounterHW {
    private int counter = 0;
    private final Object lock1 = new Object(); // Внешний объект для синхронизации
    private final Object lock2 = new Object(); // Внешний объект для синхронизации

    public void increment() {
        synchronized (lock1) {
            counter++;
        }
    }

    public void decrement() {
        synchronized (lock2) {
            counter--;
        }
    }

    public int getCounter() {
        synchronized (lock1) {
            return counter;
        }
    }
}
