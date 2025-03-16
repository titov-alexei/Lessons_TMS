package Lesson14;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Lesson14 {

    public static void main(String[] args) throws InterruptedException {
        createThreadCounter();  //Задача №1
        realisationRunnable();  //Задача №2
        synchronizedThread();   //Задача №3
        createAtomic();         //Задача №4
        twoThreadsWithJoin();   //Задача №5
        changeWithCompareAndSet();//Задача 6: Использование метода compareAndSet из AtomicInteger
        createFiveThreads();    //Задача 7: Создание нескольких потоков для вывода чисел
        severalMethods();       //Задача 8: Синхронизация нескольких методов
        synInObject();          //Задача 9: Синхронизация через объект
        atomicBooleanExample(); //Задача 10: Применение AtomicBoolean
    }

    /*
    Задача 1:Создание потока с использованием класса Thread
    Задание: Создайте класс Counter, который будет увеличивать счетчик на 1 в каждом потоке, используя класс Thread.
    */
    public static void createThreadCounter() {
        System.out.println("Задача 1:Создание потока с использованием класса Thread");
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();
        System.out.println("Count " + counter.getIncrement());
    }

    /*
    Задача 2: Реализация интерфейса Runnable
    Задание: Реализуйте интерфейс Runnable, который будет выводить номер потока 100 раз.
    */
    public static void realisationRunnable() {
        System.out.println("Задача 2: Реализация интерфейса Runnable");
        Thread myThread = new Thread(new MyThread());
        myThread.setName("Мой поток");
        myThread.start();
    }

    /*
    Задача 3: Синхронизация потоков с использованием ключевого слова synchronized
    Задание: Создайте два потока, которые одновременно увеличивают значение переменной. Синхронизируйте доступ к этой переменной.
    */
    public static void synchronizedThread() {
        System.out.println("Задача 3: Синхронизация потоков с использованием ключевого слова synchronized");
        Counter3 counter3 = new Counter3();
        Thread thread1 = new Thread(() -> {
        for (int i = 0; i < 100; i++) {
            counter3.increment();
        }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter3.increment();
            }
        });

        thread1.start();
        thread2.start();
        System.out.println(counter3.getIncrement());
    }

    /*
    Задача 4: Использование атомарного типа AtomicInteger
    Задание: Используйте AtomicInteger для безопасного увеличения счетчика в многозадачной среде.
    */
    public static void createAtomic() throws InterruptedException {
        System.out.println("Задача 4: Использование атомарного типа AtomicInteger");
        AtomicInteger number = new AtomicInteger(0);
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                number.incrementAndGet();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                number.incrementAndGet();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(number);
    }

    /*
    Задача 5: Применение метода join для ожидания завершения потока
    Задание: Создайте два потока и используйте метод join для ожидания их завершения перед выводом результата.
    */
    public static void twoThreadsWithJoin() throws InterruptedException {
        System.out.println("Задача 5: Применение метода join для ожидания завершения потока");
        Thread thread1 = new Thread(() -> {
        for(int i = 0; i < 100; i++) {
            System.out.println("Поток 1 " + i);
        }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                System.out.println("Поток 2 " + i);
            }
        });

        thread1.start();
        thread1.join(); //Ожидание завершения потока
        thread2.start();
        thread2.join(); //Ожидание завершения потока
    }

    /*
    Задача 6: Использование метода compareAndSet из AtomicInteger
    Задание: Реализуйте пример, в котором используется метод compareAndSet из
    AtomicInteger для условного изменения значения.
     */
    public static void changeWithCompareAndSet() throws InterruptedException {
        System.out.println("Задача 6: Использование метода compareAndSet из AtomicInteger");
        AtomicInteger number = new AtomicInteger(0);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                number.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " " + number);
                number.compareAndSet(20, 0);
            }
        });

        thread1.start();
        thread1.join();
        System.out.println("Number = " + number);
    }

    /*
    Задача 7: Создание нескольких потоков для вывода чисел
    Задание: Создайте 5 потоков, каждый из которых будет выводить число от 1 до 100.
     */
    public static void createFiveThreads() {
        System.out.println("Задача 7: Создание нескольких потоков для вывода чисел");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                for(int j = 0; j < 100; j++) {
                    System.out.println(Thread.currentThread().getName() + " " + j);
                }
            });
            thread.start();
            System.out.println(thread.getName() + " started...");
        }

    }

    /*
    Задача 8: Синхронизация нескольких методов
    Задание: Используйте ключевое слово synchronized для синхронизации нескольких методов класса.
     */
    public static void severalMethods() {
        System.out.println("Задача 8: Синхронизация нескольких методов");
        SeveralCount count = new SeveralCount();
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                count.increment();
                System.out.println(count.getCounter() + " " + Thread.currentThread().getName());
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                count.decrement();
                System.out.println(count.getCounter() + " " + Thread.currentThread().getName());
            }
        });
        threadOne.start();
        threadTwo.start();
    }

    /*
    Задача 9: Синхронизация через объект
    Задание: Синхронизируйте доступ к переменной через внешний объект.
     */
    public static void synInObject() throws InterruptedException {
        System.out.println("Задача 9: Синхронизация через объект");
        LockInObject counter1 = new LockInObject();

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter1.increment();
                System.out.println(counter1.getCounter() + " " + Thread.currentThread().getName());
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter1.increment();
                System.out.println(counter1.getCounter() + " " + Thread.currentThread().getName());
            }
        });
        threadOne.start();
        threadTwo.start();
    }


    /*
    Задача 10: Применение AtomicBoolean
    Задание: Используйте AtomicBoolean для атомарного изменения состояния (например,
    для флага завершения работы потока).
     */
    public static void atomicBooleanExample() {
        System.out.println("Задача 10: Применение AtomicBoolean");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Thread threadOne = new Thread(() -> {
            while(true) {
                System.out.println(Thread.currentThread().getName() + " atomicBoolean is " + atomicBoolean.get());

                if(atomicBoolean.compareAndSet(true, false)) {
                    System.out.println("Done!");
                    break;
                }
            }
        });

        Thread threadTwo = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ", AtomicBoolean = " + atomicBoolean.get());
            System.out.println(Thread.currentThread().getName() + " is setting AtomicBoolean true ");

            atomicBoolean.set(true);
            System.out.println(Thread.currentThread().getName() + ", Atomic Variable: " + atomicBoolean.get());
        });

        threadOne.start();
        threadTwo.start();
    }

}

//Класс для задачи 1:Создание потока с использованием класса Thread
class Counter extends Thread {
    private int count;

    void increment() {
        count++;
        System.out.println(count);
    }

    int getIncrement() {
        return count;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Поток " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " поток завершился");
    }
}

//Класс для задачи 2: Реализация интерфейса Runnable
class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}

/*
Класс для задачи 3: Синхронизация потоков с использованием ключевого слова synchronized
Задание: Создайте два потока, которые одновременно увеличивают значение переменной. Синхронизируйте доступ к этой переменной.
 */
class Counter3 {
    private int counter;

    public synchronized void increment() {
        counter++;
        System.out.println(counter);
    }

    public int getIncrement() {
        return counter;
    }
}

//Класс для задачи 8: Синхронизация нескольких методов
class SeveralCount {
    private int counter;

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }
}

//Класс для задачи 9: Синхронизация через объект
class LockInObject {
    private int counter = 0;
    private final Object lock = new Object(); // Внешний объект для синхронизации

    public void increment() {
        synchronized (lock) {
            counter++;
        }
    }

    public int getCounter() {
        synchronized (lock) {
            return counter;
        }
    }
}



