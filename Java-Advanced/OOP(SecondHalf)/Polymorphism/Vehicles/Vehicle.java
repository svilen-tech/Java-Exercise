package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;
    public boolean emptyBus = false;

    protected Vehicle(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    public boolean isEmptyBus() {
        return emptyBus;
    }

    public void setEmptyBus(boolean emptyBus) {
        this.emptyBus = emptyBus;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    public void setTankCapacity(double tankCapacity){
        this.tankCapacity=tankCapacity;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void drive(double kilometers) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (this.getFuelQuantity() < this.fuelConsumption * kilometers) {
            System.out.printf("%s needs refueling%n", getClass().getSimpleName());
        } else {
            this.fuelQuantity -= this.fuelConsumption * kilometers;
            System.out.printf("%s travelled %s km%n", getClass().getSimpleName(), decimalFormat.format(kilometers));
        }
    }

    protected void refuel(double litres) {
        if (litres <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (litres+getFuelQuantity() > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += litres;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
