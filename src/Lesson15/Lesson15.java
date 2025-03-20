package Lesson15;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson15 {

    public static void main(String[] args) throws InterruptedException {
        task1(); //Задача 1. Проблема видимости переменной между потоками
        task2(); //Задача 2. Монитор объекта
        task3(); //Задача 3: Защита ресурса
        task4(); //Задача 4. Попытка захвата блокировки
        task5(); //Задача 5. Ожидание выполнения всех потоков
        synchronizationThreadsGroup();    //Задача 6. Синхронизация группы потоков
        runParkingLot();                //Задача 7: Ограниченный доступ к ресурсу
        poolThreads();      //Задача 8: Пул потоков. Используй ThreadPoolExecutor для обработки 10 задач
        queueThreads();     //Задача 9: Потокобезопасная очередь
        useCyclicBarrier(); //Задача 10: Использование CyclicBarrier для синхронизации нескольких потоков.
    }

    /*
    Задача 1. Проблема видимости переменной между потоками
    Создай класс Counter, в котором один поток увеличивает volatile int count,
    а другой поток ждет, пока count достигнет 10, и затем выводит "Достигнуто 10".
     */
    public static void task1() {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (counter.getIncrement() < 10) {
            }
            System.out.println("Thread 2. End work count = " + counter.getIncrement());
        });

        thread1.start();
        thread2.start();
    }

    /*
    Задача 2. Монитор объекта
    Реализуй класс BankAccount, в котором два потока одновременно пытаются снять деньги.
    Используй synchronized, чтобы избежать состояния гонки.
     */
    public static void task2() {
        BankAccount balance = new BankAccount();
        Thread account1 = new Thread(() -> {
            balance.withdraw(700);
            System.out.println(Thread.currentThread().getName() + " Balance: " + balance.getBalance());
        });

        Thread account2 = new Thread(() -> {
            balance.withdraw(500);
            System.out.println(Thread.currentThread().getName() + " Balance: " + balance.getBalance());
        });

        account1.start();
        account2.start();
    }

    /*
    Задача 3: Защита ресурса
    Создай класс SharedResource, к которому могут обращаться несколько потоков.
    Используй ReentrantLock, чтобы предотвратить одновременный доступ.
     */
    public static void task3() {
        SharedResources sharedResources = new SharedResources();

        Thread thread1 = new Thread(sharedResources::access);
        Thread thread2 = new Thread(sharedResources::access);

        thread1.start();
        thread2.start();
    }

    /*
    Задача 4. Попытка захвата блокировки
    Напиши программу, где два потока пытаются одновременно
    захватить ReentrantLock.
    Один поток использует tryLock() и, если не может захватить,
    выполняет другую работу.
     */
    public static void task4() {
        NewSharedResources newSharedResources = new NewSharedResources();
        Thread thread1 = new Thread(newSharedResources::block);
        Thread thread2 = new Thread(newSharedResources::block);
        thread1.start();
        thread2.start();
    }

    /*
    Задача 5. Ожидание выполнения всех потоков
    Запусти 5 потоков, каждый из которых выполняет задачу 2 секунды,
    а затем вызывает countDown(). Основной поток должен дождаться всех потоков перед продолжением.
     */
    public static void task5() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Runnable runnable = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("End thread " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                countDownLatch.countDown();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        countDownLatch.await();
    }

    /*
    Задача 6: Синхронизация группы потоков
    Реализуй программу, где 3 потока выполняют работу и ждут друг друга на
    CyclicBarrier. Когда все потоки достигли барьера, они продолжают выполнение.
     */
    public static void synchronizationThreadsGroup() {
        System.out.println("Задача 6: Синхронизация группы потоков");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("Все потоки достигли барьера! Продолжаем...");
        });

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " работает");
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " ожидает на барьере");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " продолжает работу.");
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    /*
    Задача 7: Ограниченный доступ к ресурсу
    Создай класс ParkingLot с Semaphore(3), где 5 машин пытаются припарковаться, но
    одновременно могут занять только 3 места.
     */
    public static void runParkingLot() {
        System.out.println("Задача 7: Ограниченный доступ к ресурсу");
        ParkingLot parkingLot = new ParkingLot();
        Thread thread1 = new Thread(parkingLot::addCar);
        Thread thread2 = new Thread(parkingLot::addCar);
        Thread thread3 = new Thread(parkingLot::addCar);
        Thread thread4 = new Thread(parkingLot::addCar);
        Thread thread5 = new Thread(parkingLot::addCar);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    /*
    Задача 8: Пул потоков
    Используй ThreadPoolExecutor для обработки 10 задач, каждая из которых
    выполняется 1 секунду.
     */
    public static void poolThreads() {
        System.out.println("Задача 8: Пул потоков. Используй ThreadPoolExecutor для обработки 10 задач");
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " запущен...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
    }

    /*
    Задача 9: Потокобезопасная очередь
    Реализуй очередь с BlockingQueue, куда один поток добавляет элементы, а другой
    извлекает их с интервалом в 1 секунду.
     */
    public static void queueThreads() {
        System.out.println("Задача 9: Потокобезопасная очередь");
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();


        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();

    }

    /*
    Задача 10: Использование CyclicBarrier для синхронизации нескольких потоков.
    Есть 4 потока, каждый из которых выполняет часть задачи. Все потоки должны завершить
    свои работы, прежде чем главный поток продолжит выполнение. Нужно синхронизировать
    потоки так, чтобы они все начинали работать одновременно и завершили выполнение
    одновременно.
     */
    public static void useCyclicBarrier() {
        System.out.println("Задача 10: Использование CyclicBarrier для синхронизации нескольких потоков.");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("Все потоки достигли барьера! Продолжаем...");
        });

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " работает");
            Random random = new Random();
            try {
                Thread.sleep(1000 + random.nextInt(500, 5000));
                System.out.println(Thread.currentThread().getName() + " ожидает");
                cyclicBarrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " продолжает работу");
        };

        new Thread(worker).start();
        new Thread(worker).start();
        new Thread(worker).start();
        new Thread(worker).start();

    }
}


//Для задачи 9
class Producer implements Runnable {
    private final BlockingQueue<String> queue;

    Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                queue.add("Элемент " + i);
                System.out.println("Добавлен: Элемент " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<String> queue;
    Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String str;
        try {
            while ((str = queue.poll()) != null) {
                System.out.println("Вывод " + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//Для задачи 7
class ParkingLot extends Thread{
    Semaphore semaphore = new Semaphore(3);

    private int count = 0;

    void addCar() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " занял место");
            count++;
            Thread.sleep(2000);
            System.out.println("Cars: " + count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " освобождает место");
            count--;
            semaphore.release();
        }
    }
}

//Для задачи 4
class NewSharedResources {
    private final ReentrantLock lock = new ReentrantLock();

    void block() {
        if(lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " lock...");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " failed...");
        }
    }
}

//Для задачи 3
class SharedResources {
    private final ReentrantLock lock = new ReentrantLock();

    public void access() {
        lock.lock();

        System.out.println(Thread.currentThread().getName() + " Asked for cats, waiting...");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("OK");
        lock.unlock();
    }
}

//Для задачи 2
class BankAccount {
    private int balance = 1000;

    synchronized void withdraw(int number) {
        if (balance < number) {
            System.out.println("Недостаточно средств");
        } else {
            balance -= number;
        }
    }

    int getBalance() {
        return balance;
    }
}

//Для задачи 1
class Counter extends Thread {
    private volatile int count;

    void increment() {
        count++;
        System.out.println(count);
    }

    void decrement() {
        count--;
        System.out.println(count);
    }

    int getIncrement() {
        return count;
    }


}

