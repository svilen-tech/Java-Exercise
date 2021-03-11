package Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double literPerKm,double tankCapacity) {
        super(fuelQuantity, literPerKm+0.9,tankCapacity);
    }

}
