package com.company;

import java.util.Scanner;

public class DisneyLandJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wage = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());

        double moneyCollected = 0;

        for (int i = 1; i <=months ; i++) {
            if(i%2==1&&i!=1){
                moneyCollected = moneyCollected * 0.84;
            }if(i%4==0){
                double tempBonus = moneyCollected*0.25;
                moneyCollected = moneyCollected+tempBonus;
            }
            moneyCollected = moneyCollected+(wage*0.25);
        }
        if (moneyCollected>=wage){
            double diff = moneyCollected-wage;
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.",diff);
        }else{
            double diff = wage-moneyCollected;
            System.out.printf("Sorry. You need %.2flv. more.", diff);
        }
    }
}
