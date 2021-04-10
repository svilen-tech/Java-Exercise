package com.company;

import java.util.*;
import java.util.regex.Pattern;

public class ThirdMidExamPrep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        List<String> items = new ArrayList<>();
        for (int i = 0; i <input.length ; i++) {
            items.add(input[i]);
        }
        String[] command = scanner.nextLine().split(" - ");
        while (!command[0].equals("Craft!")){

            String firstCom = command[0];
            String secondCom = command[1];
            String [] replace = secondCom.split(":");
            switch (command[0]) {
                case "Collect":
                  if( items.contains(secondCom)){
                      break;
                  }else{
                      items.add(secondCom);
                  }
                  break;
                case "Drop":
                    items.remove(secondCom);
                    break;
                case"Combine Items":
                    if (items.contains(replace[0])){
                        int neededIndex =items.indexOf(replace[0]);
                        items.add(neededIndex+1,replace[1]);
                        break;
                    }else{
                        break;
                    }
                case "Renew":
                    if (items.contains(secondCom)){
                        items.remove(secondCom);
                        items.add(secondCom);
                    }
                    break;

            }
            command = scanner.nextLine().split(" - ");;
        }
        StringJoiner joiner = new StringJoiner(", ");
        for (String item : items) {
            joiner.add(item);
        }
        System.out.println(joiner.toString());
    }
}
