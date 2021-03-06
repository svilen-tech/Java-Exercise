package InterfaceAndAbstraction.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Robot> robots = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] arr = input.split(" ");
            if (arr.length>2){
                String name = arr[0];
                int age = Integer.parseInt(arr[1]);
                String id = (arr[2]);
                Citizen citizen = new Citizen(name,age,id);
                citizens.add(citizen);

            }else {
                String model = arr[0];
                String id = (arr[1]);
                Robot robot = new Robot(model,id);
                robots.add(robot);
            }

            input=scanner.nextLine();
        }
        String toDell = scanner.nextLine();
        for (int i = 0;i<citizens.size();i++) {
            String sub = citizens.get(i).getId().substring(citizens.get(i).getId().length()-3);
            if (sub.equals(toDell)){
                System.out.println(citizens.get(i).getId());
                citizens.remove(citizens.get(i));
                i--;
            }

        }
        for (int i = 0;i<robots.size();i++) {
            String sub = robots.get(i).getId().substring( robots.get(i).getId().length()-3);
            if (sub.equals(toDell)){
                System.out.println(robots.get(i).getId());
                robots.remove(robots.get(i));
                i--;
            }

        }

    }
}
