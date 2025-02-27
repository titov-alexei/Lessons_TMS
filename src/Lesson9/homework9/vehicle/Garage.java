package Lesson9.homework9.vehicle;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private List<Vehicle> garage = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        garage.add(vehicle);
    }

    public void startAllVehicle() {
        for (Vehicle array : garage) {
            array.start();
        }
    }

    public void stopAllVehicle() {
        for (Vehicle array : garage) {
            array.stop();
        }
    }
}
