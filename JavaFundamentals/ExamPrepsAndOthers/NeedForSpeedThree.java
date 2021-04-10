package FinalExamPreparation;

import java.util.*;

public class NeedForSpeedThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carList = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            carList.put(car,new ArrayList<>());
            carList.get(car).add(mileage);
            carList.get(car).add(fuel);
        }
        String input = scanner.nextLine();
        while(!input.equals("Stop")){
            String[] commands = input.split(" : ");
            String typeCommand = commands[0];
            String car = commands[1];
            if (typeCommand.equals("Drive")){
                int distance = Integer.parseInt(commands[2]);
                int fuel = Integer.parseInt(commands[3]);
                if (fuel>carList.get(car).get(1)){
                    System.out.println("Not enough fuel to make that ride");
                }else{
                    int newCarMilage = carList.get(car).get(0)+distance;
                    int newFuel = carList.get(car).get(1)-fuel;
                    carList.get(car).set(0,newCarMilage);
                    carList.get(car).set(1,newFuel);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",car,distance,fuel);
                }
                int checkMiles = carList.get(car).get(0);
                if (checkMiles>=100000){
                    carList.remove(car);
                    System.out.println("Time to sell the "+ car+"!");
                }
            }else if(typeCommand.equals("Refuel")){
                int fuel = Integer.parseInt(commands[2]);
                int fuelToFill = carList.get(car).get(1)+fuel;
                int filledFuel = fuel;
                if (carList.get(car).get(1)+fuel>75){
                    fuelToFill=75;
                    filledFuel=75-carList.get(car).get(1);
                }
                carList.get(car).set(1,fuelToFill);
                System.out.println(car+" refueled with "+filledFuel+" liters");

            }else if(typeCommand.equals("Revert")){
                int km = Integer.parseInt(commands[2]);
                int decresedKM = carList.get(car).get(0)-km;
                if (decresedKM<10000){
                    carList.get(car).set(0,10000);
                }else{
                    carList.get(car).set(0,decresedKM);
                    System.out.printf("%s mileage decreased by %d kilometers%n",car,km);
                }
            }

            input = scanner.nextLine();
        }
        carList.entrySet().stream()
                .sorted((a,b)->{
                    int result = b.getValue().get(0)-a.getValue().get(0);
                    if (result==0){
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                }).forEach((a)->{
            System.out.println(a.getKey()+" -> Mileage: "+ a.getValue().get(0)+" kms, Fuel in the tank: "+ a.getValue().get(1)+ " lt.");
        });
    }
}
