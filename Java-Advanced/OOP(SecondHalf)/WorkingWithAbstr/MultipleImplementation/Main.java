package InterfaceAndAbstraction.MultipleImplementation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Birthable> personList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] arr = input.split(" ");
            String type = arr[0];

            switch (type){
                case "Robot":
                    Robot robot = new Robot(arr[1],arr[2]);
                    break;
                case "Citizen":
                    personList.add(new Citizen(arr[1], Integer.parseInt(arr[2]),arr[3],arr[4]));
                    break;
                case "Pet":
                    personList.add(new Pet(arr[1],arr[2]));

                    break;
            }
            input=scanner.nextLine();
        }
        String prefix= scanner.nextLine();
        for (Birthable birthable : personList) {
            if (birthable.getBirthDate().endsWith(prefix)){
                System.out.println(birthable);
            }
        }
    }
}
