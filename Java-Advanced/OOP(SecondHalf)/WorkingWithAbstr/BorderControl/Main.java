package InterfaceAndAbstraction.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] arr = input.split(" ");
            if (arr.length>2){
                String name = arr[0];
                int age = Integer.parseInt(arr[1]);
                String id = (arr[2]);
               identifiables.add(new Citizen(name,age,id));


            }else {
                String model = arr[0];
                String id = (arr[1]);
               identifiables.add(new Robot(model,id));

            }

            input=scanner.nextLine();
        }
        String toDell = scanner.nextLine();
        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(toDell)){
                System.out.println(identifiable.getId());
            }
        }

    }
}
