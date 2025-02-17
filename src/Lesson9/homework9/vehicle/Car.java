package Lesson9.homework9.vehicle;

import Leeson7.Cat;

public class Car implements Vehicle{

    private final String title;
    private final String brand;

    Car(String title, String brand) {
        this.title = title;
        this.brand = brand;
    }

    @Override
    public void start() {
        System.out.println("Машина " + title + " начала движение");
    }

    @Override
    public void stop() {
        System.out.println("Машина " + title + " остановилась");
    }

    @Override
    public void displayInfo() {
        System.out.println("Название: " + title + " Бренд машины " + brand);

    }
}
