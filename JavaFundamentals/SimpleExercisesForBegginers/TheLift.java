package com.company;

import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tourist = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String[] line = input.split(" ");
        int[] wagons = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            wagons[i] = Integer.parseInt(line[i]);
        }

        for (int i = 0; i < wagons.length; i++) {
            int wagonsCapacity = wagons[i];
            while (wagonsCapacity < 4&&0<tourist) {
                wagons[i] = wagons[i] + 1;
                wagonsCapacity++;
                tourist--;
            }
        }
        for (int i = 0; i < wagons.length; i++) {

            if (wagons[i] != 4) {
                System.out.println("The lift has empty spots!");
                for (int j = 0; j < wagons.length; j++) {
                    System.out.print(wagons[j] + " ");
                }
                return;
            }
        }
            if (0 < tourist) {
                System.out.printf("There isn't enough space! %d people in a queue!%n", tourist);
                for (int j = 0; j < wagons.length; j++) {
                    System.out.print(wagons[j] + " ");
                }
            } else {
                for (int j = 0; j < wagons.length; j++) {
                    System.out.print(wagons[j] + " ");
                }
            }
        }
    }

