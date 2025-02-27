package Lesson9.homework9.vehicle;

public class Bike implements Vehicle{

    private final String title;
    private final String type;

    Bike(String title, String type) {
        this.title = title;
        this.type = type;
    }

    @Override
    public void start() {
        System.out.println("Велосипед " + title + " начал движение");
    }

    @Override
    public void stop() {
        System.out.println("Велосипед " + title + " остановился");
    }

    @Override
    public void displayInfo() {
        System.out.println("Название: " + title + " Тип велосипеда " + type);
    }
}
