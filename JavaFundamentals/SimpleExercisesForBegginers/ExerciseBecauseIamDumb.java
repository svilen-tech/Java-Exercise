package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseBecauseIamDumb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> targets = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            targets.add(Integer.parseInt(input[i]));
        }
        String[] command = scanner.nextLine().split(" ");
        while(!command[0].equals("End")){
            int index = Integer.parseInt(command[1]);
            int powerOrValue = Integer.parseInt(command[2]);

            switch (command[0]){
                case "Shoot":
                    if (index<targets.size()){
                        int reducedValue = targets.get(index) - powerOrValue;
                        targets.set(index,reducedValue);
                        if (reducedValue<=0){
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (index<targets.size()){
                        targets.add(index,powerOrValue);
                    }else{
                        System.out.println("Invalid placement!");
                    }
                    break;
                case"Strike":

                    if (index+powerOrValue> targets.size()||index-powerOrValue<0){
                        System.out.println("Strike missed!");
                    }else {
                        int tempValue =targets.get(index+1);

                        for (int i = index; i >=index-powerOrValue ; i--) {
                            targets.remove(i);
                        }
                        int tempIndex = targets.indexOf(tempValue);
                        int count=tempIndex;
                        while(!(tempIndex==count+powerOrValue)&&targets.size()>0){
                            targets.remove(count);
                            tempIndex++;
                        }
                    }
                    break;
            }



            command= scanner.nextLine().split(" ");
        }
        for (int i = 0; i <targets.size() ; i++) {
            if (i<targets.size()-1){
                System.out.print(targets.get(i)+"|");
            }else {
                System.out.print(targets.get(i));
            }
        }


    }
}
