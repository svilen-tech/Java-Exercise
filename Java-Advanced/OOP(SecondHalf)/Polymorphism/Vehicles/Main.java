package Vehicles;

import java.lang.invoke.VarHandle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] infoCar = scanner.nextLine().split(" ");
        String[] infoTruck = scanner.nextLine().split(" ");
        String[] infoBus = scanner.nextLine().split(" ");

        Vehicle car = new Car(Double.parseDouble(infoCar[1]), Double.parseDouble(infoCar[2]),
                Double.parseDouble(infoCar[3]));
        Vehicle truck = new Truck(Double.parseDouble(infoTruck[1]), Double.parseDouble(infoTruck[2])
                ,Double.parseDouble(infoTruck[3]));
        Vehicle bus = new Bus(Double.parseDouble(infoBus[1]), Double.parseDouble(infoBus[2])
                ,Double.parseDouble(infoBus[3]));
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Drive")||input[0].equals("DriveEmpty")) {
                switch (input[1]) {
                    case "Car":
                        car.drive(Double.parseDouble(input[2]));
                        break;
                    case "Truck":
                        truck.drive(Double.parseDouble(input[2]));
                        break;
                    case "Bus":
                        if (input[0].equals("Drive")){
                            bus.setFuelConsumption(bus.getFuelConsumption()+1.4);
                        }else {
                            bus.setFuelConsumption(Double.parseDouble(infoBus[2]));
                        }
                        bus.drive(Double.parseDouble(input[2]));
                        break;


                }
            } else if (input[0].equals("Refuel")) {
                switch (input[1]) {
                    case "Car":
                        car.refuel(Double.parseDouble(input[2]));
                        break;
                    case "Truck":
                        truck.refuel(Double.parseDouble(input[2]));
                        break;
                    case"Bus":
                        bus.refuel(Double.parseDouble(input[2]));
                        break;
                }
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}