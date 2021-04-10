package com.company;

import javax.xml.stream.events.EndDocument;
import java.util.Scanner;

public class SecondMidExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");

        int health = 100;
        int bitcoins = 0;
        int count = 0;

        for (int i = 0; i <input.length ; i++) {
            String[] order = input[i].split(" ");
            String command = order[0];
            int command1 = Integer.parseInt(order[1]);
          switch (command) {
              case ("potion"):
                  if (health + command1 >= 100) {
                      int oldHealth = health;
                      health = 100;
                      command1= health-oldHealth;
                  } else {
                      health = health + command1;
                  }
                  System.out.printf("You healed for %d hp.%n", command1);
                  System.out.printf("Current health: %d hp.%n", health);
                  count++;
                  break;
              case ("chest"):
                  bitcoins = bitcoins + command1;
                  System.out.printf("You found %d bitcoins.%n", command1);
                  count++;
                  break;
              default:
                  if (health - command1 > 0) {
                      health = health- command1;
                      System.out.printf("You slayed %s.%n", command);

                  } else {
                      System.out.printf("You died! Killed by %s.%n", command);
                      count++;
                      System.out.printf("Best room: %d", count);
                      return;
                  }
                  count++;
                  break;

          }
        }
        System.out.println("You've made it!");
        System.out.printf( "Bitcoins: %d%n",bitcoins);
        System.out.printf("Health: %d", health);
    }
}
