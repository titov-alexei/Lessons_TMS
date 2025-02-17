package Lesson9.homework9.vehicle;

public class Motorcycle implements Vehicle {

    private final String title;
    private final String engineCapacity;

    Motorcycle(String title, String engineCapacity) {
        this.title = title;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        System.out.println("Мотоцикл начал движение");
    }

    @Override
    public void stop() {
        System.out.println("Мотоцикл остановился");
    }

    @Override
    public void displayInfo() {
        System.out.println("Название: " + title + " Объем двигателя: " + engineCapacity);
    }
}
