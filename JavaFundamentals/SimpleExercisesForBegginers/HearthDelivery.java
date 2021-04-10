package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class HearthDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("@");
        List<Integer> houses = new ArrayList<>();
        for (int i = 0; i <line.length ; i++) {
            houses.add(Integer.parseInt(line[i]));
        }
        String[] commands = scanner.nextLine().split(" ");
        int index=0;
        while (!commands[0].equals("Love!")){
            index += Integer.parseInt(commands[1]);
            if (index>houses.size()-1){
                index=0;
            }
            int removedValue = houses.get(index);
            if (removedValue<=0){
                System.out.printf("Place %d already had Valentine's day.%n",index);
            }else {
                int valueToRemove = removedValue - 2;
                houses.set(index,valueToRemove);
                if (valueToRemove==0){
                    System.out.printf("Place %d has Valentine's day.%n",index);
                }

            }



            commands = scanner.nextLine().split(" ");
        }

        System.out.printf("Cupid's last position was %d.%n", index);
        boolean nullsOnly = houses.stream().noneMatch(Objects::nonNull);

        if (nullsOnly){
            System.out.println("Mission was successful");
        }else {
            int housesNotNull = 0;
            for (int i = 0; i < houses.size(); i++) {
                if(houses.get(i)!=0){
                    housesNotNull++;
                }
            }
            System.out.printf("Cupid has failed %d places.", housesNotNull);
        }
    }
}
