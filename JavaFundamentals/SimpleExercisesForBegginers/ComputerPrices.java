package com.company;

import java.util.Scanner;

public class ComputerPrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalPrice = 0;
        while(!input.equals("special")&&!input.equals("regular")){
            double tempPrice = Double.parseDouble(input);
            if (tempPrice<0){
                System.out.println("Invalid price!");
            }else {
                totalPrice = totalPrice + tempPrice;
            }




            input = scanner.nextLine();
        }
        if(totalPrice==0){
            System.out.println("Invalid order!");
            return;
        }
        double taxes =totalPrice*0.20;
        double priceWithTaxes = totalPrice+taxes;
       if (input.equals("special")){
           priceWithTaxes= priceWithTaxes*0.90;
       }

        System.out.printf("Congratulations you've just bought a new computer!%nPrice without taxes: %.2f$%nTaxes: %.2f$%n-----------%nTotal price: %.2f$%n",totalPrice,taxes,priceWithTaxes);
    }
}
