package com.company;

import java.util.*;

public class Commands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        int[] stringAsNumbers = new int[numbers.length];
        for (int i = 0; i <numbers.length ; i++) {
            stringAsNumbers[i]=Integer.parseInt(numbers[i]);
        }

        String[] commands = scanner.nextLine().split(" ");
        while (!commands[0].equals("end")){
            if (commands[0].equals("sort")){
                int from = Integer.parseInt(commands[2]);
                int toCount = Integer.parseInt(commands[4])+from;
                for (int i = from; i < toCount; i++) {
                    for (int j = i+1; j <toCount ; j++) {
                        if (stringAsNumbers[i]>stringAsNumbers[j]){
                            int temp = stringAsNumbers[i];
                            stringAsNumbers[i]=stringAsNumbers[j];
                            stringAsNumbers[j]=temp;
                        }
                    }
                }
            }else if(commands[0].equals("reverse")){
                int from = Integer.parseInt(commands[2]);
                int toCount = Integer.parseInt(commands[4])+from;
                int count =0;
                for (int i = from; i <=toCount/2 ; i++) {

                    int temp = stringAsNumbers[toCount-count-1];
                    stringAsNumbers[toCount-count-1]=stringAsNumbers[i];
                    stringAsNumbers[i]=temp;
                    count++;
                }
            }else if (commands[0].equals("remove")){
                int from = Integer.parseInt(commands[1]);
                for (int i = 0; i <from ; i++) {
                    stringAsNumbers[i]=0;
                }
            }



            commands = scanner.nextLine().split(" ");
        }

        for (int i = 0; i <stringAsNumbers.length ; i++) {
            if (stringAsNumbers[i]!=0&&i<stringAsNumbers.length-1){
                System.out.print(stringAsNumbers[i]+", ");
            }else if((stringAsNumbers[i]!=0)){
                System.out.print(stringAsNumbers[i]);
            }
        }
    }
}
