package DefiningClasses.SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Car>carMap = new LinkedHashMap<>();
        for (int i = 0; i <n ; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double fuelConsumption = Double.parseDouble(input[2]);
            Car car = new Car();
            carMap.put(model,car = new Car(model,fuel,fuelConsumption));

        }
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String []splited= input.split(" ");
            String model = splited[1];
            int distance =Integer.parseInt(splited[2]);
            carMap.get(model).drive(distance);

            input=scanner.nextLine();
        }
        for (String s : carMap.keySet()) {
            String mod =carMap.get(s).getModel();
            double fuel = carMap.get(s).getFuel();
            int distnace = carMap.get(s).getTotalDistance();
            System.out.printf("%s %.2f %d%n",mod,fuel,distnace);
        }
    }
}
