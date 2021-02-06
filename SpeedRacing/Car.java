package DefiningClasses.SpeedRacing;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private double fuel;
    private double fuelCost;
    private int distanceTraveled;
    private double leftFuel;
    private int totalDistance;


    List<Car> carList = new ArrayList<>();

    public Car(String model, double fuel, double fuelCost) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCost = fuelCost;
    }

    public Car() {
    }

    public String getModel() {
        return this.model;
    }

    public double getFuel() {
        return this.fuel;
    }

    public double getFuelCost() {
        return this.fuelCost;
    }

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuel(int fuel) {

        this.fuel = fuel;
    }

    public void setFuelCost(double fuelCost) {

        this.fuelCost = fuelCost;
    }

    public void setDistanceTraveled(int distanceTraveled) {

        this.distanceTraveled = distanceTraveled;
    }

    public double getLeftFuel() {

        return leftFuel;
    }

    public void setLeftFuel(double leftFuel) {

        this.leftFuel = leftFuel;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void drive(int distanceTraveled) {

        double leftFel = fuel;
        leftFel = fuel - (fuelCost * distanceTraveled);
        if (leftFel >= 0) {
            fuel = leftFel;
            leftFuel = fuel;
            totalDistance += distanceTraveled;

        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public void Print() {
        System.out.printf("%s %.2f %d", model, leftFuel, totalDistance);
    }
}
