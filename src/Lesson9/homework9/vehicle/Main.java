package Lesson9.homework9.vehicle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №3. Урок 9. Создание ТС и добавление их в гараж");
        Car car1 = new Car("Car 1", "Tesla");
        Car car2 = new Car("Car 2", "BMW");
        Bike bike1 = new Bike("Bike 1", "Горник");
        Motorcycle moto1 = new Motorcycle("Motorcycle 1", "900 см3");
        Garage myGarage = new Garage();
        myGarage.addVehicle(car1);
        myGarage.addVehicle(car2);
        myGarage.addVehicle(bike1);
        myGarage.addVehicle(moto1);
        myGarage.startAllVehicle();
        myGarage.stopAllVehicle();
    }
}
