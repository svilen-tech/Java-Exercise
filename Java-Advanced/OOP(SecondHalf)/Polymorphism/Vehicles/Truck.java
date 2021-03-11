package Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private static final double SUMMER_CORRECTION = 1.6;
    private static final double TANK_CORRECTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption + SUMMER_CORRECTION,tankCapacity);
    }

    @Override
    protected void refuel(double litres) {
        // setFuelQuantity (getFuelQuantity () + litres* TANK_CORRECTION);
        super.refuel(litres * 0.95);
    }
}
