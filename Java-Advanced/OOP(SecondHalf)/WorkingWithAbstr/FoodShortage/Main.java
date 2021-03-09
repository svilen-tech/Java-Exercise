package InterfaceAndAbstraction.FoodShortage.FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Buyer> map = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            String[] arr = scanner.nextLine().split(" ");
            if (arr.length==3){
                Rebel rebel =new Rebel(arr[0],Integer.parseInt(arr[1]),arr[2]);
                rebel.buyFood();
                map.put(arr[0],rebel);
            }else{
                Citizen citizen = new Citizen(arr[0], Integer.parseInt(arr[1]),arr[2],arr[3]);
                citizen.buyFood();
                map.put(arr[0],citizen);
            }
        }
        String names = scanner.nextLine();
        int totalFood= 0;
        while (!names.equals("End")){
                if (map.containsKey(names)){

                    totalFood+= map.get(names).getFood();
                }


            names= scanner.nextLine();
        }
        System.out.println(totalFood);
    }
}
