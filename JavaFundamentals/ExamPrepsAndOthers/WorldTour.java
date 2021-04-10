package FinalExamPreparation;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destinations = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Travel")){
            String[] commands = input.split(":");
            String finCommand = commands[0];
            if (finCommand.equals("Add Stop")){
                int index = Integer.parseInt(commands[1]);
                String toInsert = commands[2];
                StringBuilder sb = new StringBuilder(destinations);

                if (index<=destinations.length()){
                    sb.insert(index,toInsert);
                    destinations= sb.toString();
                    System.out.println(destinations);
                }else{
                    System.out.println(destinations);
                }

            }else if (finCommand.equals("Remove Stop")){
                int startIndex = Integer.parseInt(commands[1]);
                int endIndex = Integer.parseInt(commands[2]);
                endIndex +=1;
                if (endIndex==destinations.length()){
                    endIndex = destinations.length();
                }
                StringBuilder sb = new StringBuilder(destinations);
                if (startIndex>=0&&endIndex<=destinations.length()){
                    sb.delete(startIndex,endIndex);
                    destinations=sb.toString();
                    System.out.println(destinations);
                }else {
                    System.out.println(destinations);
                }
            }else if (finCommand.equals("Switch")){
                String oldString = commands[1];
                String newString = commands[2];
                if (destinations.contains(oldString)) {
                    String k = destinations.replace(oldString, newString);
                    destinations = k;
                    System.out.println(destinations);
                }else {
                    System.out.println(destinations);
                }
            }


            input =scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: "+destinations);
    }
}
