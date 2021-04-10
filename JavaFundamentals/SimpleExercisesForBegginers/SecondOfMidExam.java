package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntToDoubleFunction;

public class SecondOfMidExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i <line.length ; i++) {
            prices.add(Integer.parseInt(line[i]));
        }

        int entryPoint = Integer.parseInt(scanner.nextLine());
        String typeItems = scanner.nextLine();
        String typePricingRating = scanner.nextLine();

        int leftItems = 0;
        int rightItems = 0;
        if (typeItems.equals("cheap")){

            if (entryPoint!=0){
                entryPoint = entryPoint-1;
            }if (entryPoint!=prices.size()-1){
                entryPoint= entryPoint+1;
            }
            int itemToLook =0;
            if (typePricingRating.equals("positive")){
                for (int i = entryPoint; i >=0 ; i--) {
                    int check = prices.get(i);
                    if (check>0&&check<prices.get(entryPoint)){
                        leftItems +=check;
                    }
                }
                for (int i = entryPoint; i <prices.size() ; i++) {
                    int checkPrice = prices.get(i);
                    if (checkPrice>0&&checkPrice<prices.get(entryPoint)){
                        rightItems+=checkPrice;
                    }
                }
            }else if(typePricingRating.equals("negative")){
                for (int i = entryPoint; i >=0 ; i--) {
                    int check = prices.get(i);
                    if (check<0&&check<prices.get(entryPoint)){
                        leftItems +=check;
                    }
                }
                for (int i = entryPoint; i <prices.size() ; i++) {
                    int checkPrice = prices.get(i);
                    if (checkPrice<0&&checkPrice<prices.get(entryPoint)){
                        rightItems+=checkPrice;
                    }
                }
            }else{
                for (int i = entryPoint; i >=0 ; i--) {
                    int check = prices.get(i);
                    if (check<prices.get(entryPoint)){
                        leftItems +=check;
                    }
                }
                for (int i = entryPoint; i <prices.size() ; i++) {
                    int checkPrice = prices.get(i);
                    if (checkPrice<prices.get(entryPoint)){
                        rightItems+=checkPrice;
                    }
                }
            }



        }else if(typeItems.equals("expensive")){

            int itemToLook =0;
            if (typePricingRating.equals("positive")){
                for (int i = entryPoint; i >=0 ; i--) {
                    int check = prices.get(i);
                    if (check>0&&check>=prices.get(entryPoint)){
                        leftItems +=check;
                    }
                }
                for (int i = entryPoint; i <prices.size() ; i++) {
                    int checkPrice = prices.get(i);
                    if (checkPrice>0&&checkPrice>=prices.get(entryPoint)){
                        rightItems+=checkPrice;
                    }
                }
            }else if(typePricingRating.equals("negative")){
                for (int i = entryPoint; i >=0 ; i--) {
                    int check = prices.get(i);
                    if (check<0&&check>=prices.get(entryPoint)){
                        leftItems +=check;
                    }
                }
                for (int i = entryPoint; i <prices.size() ; i++) {
                    int checkPrice = prices.get(i);
                    if (checkPrice<0&&checkPrice>=prices.get(entryPoint)){
                        rightItems+=checkPrice;
                    }
                }
            }else{
                for (int i = entryPoint; i >=0 ; i--) {
                    int check = prices.get(i);
                    if (check>=prices.get(entryPoint)){
                        leftItems +=check;
                    }
                }
                for (int i = entryPoint; i <prices.size() ; i++) {
                    int checkPrice = prices.get(i);
                    if (checkPrice>=prices.get(entryPoint)){
                        rightItems+=checkPrice;
                    }
                }
            }
        }
        if (leftItems>rightItems){
            System.out.println("Left" + " - " +leftItems);
        }if (rightItems>leftItems){
            System.out.println("Left" + " - " +rightItems);
        }else if (rightItems==leftItems){
            System.out.println("Left" + " - " +leftItems);
        }



    }
}





















//  for (int i = 0; i < count; i++)
//        {
//            for (int j = i + 1; j < count; j++) {
//                if (num[i] > num[j])
//                {
//                    temp = num[i];
//                    num[i] = num[j];
//                    num[j] = temp;
//                }