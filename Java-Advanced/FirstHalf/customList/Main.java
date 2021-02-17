package generics.customList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList();
        while (!input.equals("END")) {
            String[] commands = input.split("\\s+");
            String token = commands[0];
            if (token.equals("Add")) {
                customList.add(commands[1]);
            } else if (token.equals("Remove")) {
                customList.remove(Integer.parseInt(commands[1]));
            } else if (token.equals("Contains")) {
                System.out.println(customList.contains(commands[1]));
            } else if (token.equals("Swap")) {
                customList.swap(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
            } else if (token.equals("Greater")) {
                System.out.println(customList.countGreaterThan(commands[1]));
            } else if (token.equals("Max")) {
                System.out.println(customList.getMax());
            } else if (token.equals("Min")) {
                System.out.println(customList.getMin());
            } else if (token.equals("Print")) {
                System.out.println(customList.toString());
            } else if (token.equals("Sort")) {
                Sorter.sort(customList);
            }
            input = scanner.nextLine();
        }


    }
}
