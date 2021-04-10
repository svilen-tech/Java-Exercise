package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] line = input.split(" ");
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            numbers.add(line[i]);
        }
        String [] command = scanner.nextLine().split(" ");
        int count = 0;
        while(!command[0].equals("end")){
            int index1 = Integer.parseInt(command[0]);
            int index2 = Integer.parseInt(command[1]);
            count+=2;

            if (index1<0||index2<0){
                int temp = Integer.parseInt(numbers.get(count));
               int secondCount = count+1;
               int temp2 = Integer.parseInt(numbers.get(secondCount));
                System.out.println("Invalid input! Adding additional elements to the board");
                numbers.add(temp,"-"+count/2+"a");
                numbers.add(temp+1,"-"+count/2+"a");
            } else if(numbers.get((index1)).equals(numbers.get(index2))){
                String matchingElement = numbers.get(index1);
                if (index1>index2){
                    numbers.remove(index1);
                    numbers.remove(index2);
                }else {

                    numbers.remove(index2);
                    numbers.remove(index1);
                }
                System.out.printf("Congrats! You have found matching elements - %s!%n",matchingElement);

            }else{
                System.out.println("Try again!");
            }
            if (numbers.isEmpty()){
                System.out.printf("You have won in %d turns!%n", count/2);
                return;
            }


            command = scanner.nextLine().split(" ");
        }
        if (!numbers.isEmpty()) {
            System.out.println("Sorry you lose :(");

            for (String number : numbers) {
                System.out.print(number + " ");
            }
        }
    }
}
