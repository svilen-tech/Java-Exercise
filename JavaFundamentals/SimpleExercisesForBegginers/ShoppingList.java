package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("!");
        List<String> groceries = new ArrayList<>();
        for (int i = 0; i <line.length ; i++) {
            groceries.add(line[i]);
        }
        String[] commands = scanner.nextLine().split(" ");

        while(!commands[1].equals("Shopping!")){

            switch (commands[0]){

                case "Urgent":
                    if (!groceries.contains(commands[1])){
                groceries.add(0,commands[1]);    }
                    else{
                        break;
                    }
                    break;
                case "Unnecessary":
                    if (groceries.contains(commands[1])){
                        groceries.remove(commands[1]);
                    }
                    break;
                case "Correct":
                    if (groceries.contains(commands[1])){
                        int oldIndex = groceries.indexOf(commands[1]);
                        groceries.set(oldIndex, commands[2]);
                    }
                    break;
                case"Rearrange":
                    if (groceries.contains(commands[1])){
                        groceries.remove(commands[1]);
                        groceries.add(commands[1]);
                    }
                    break;
            }


           commands = scanner.nextLine().split(" ");
        }

        for (int i = 0; i <groceries.size() ; i++) {
            if (i<groceries.size()-1){
                System.out.print(groceries.get(i)+", ");
            }else{
                System.out.println(groceries.get(i));
            }
        }

    }
}
