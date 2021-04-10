package com.company;

import java.util.*;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = Arrays.stream(scanner.nextLine().split("&")).map(String::trim).toArray(String[]::new);
        List<String> library = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            library.add(line[i]);
        }

        String[] commands = Arrays.stream(scanner.nextLine().split("\\|+"))
                .map(String::trim)
                .toArray(String[]::new);


        while (!commands[0].equals("Done")) {


            switch (commands[0]) {
                case "Add Book":
                    if (!library.contains(commands[1])) {
                        library.add(0, commands[1]);
                    }
                    break;
                case "Take Book":
                    if (library.contains(commands[1])){
                        library.remove(commands[1]);
                    }
                    break;
                case "Swap Books":
                    if (library.contains(commands[1])&&library.contains(commands[2])) {
                        int indexOf = library.indexOf(commands[1]);
                        int secondIndex = library.indexOf(commands[2]);
                        String temp = commands[1];
                        library.set(indexOf, commands[2]);
                        library.set(secondIndex, commands[1]);
                    }
                    break;
                case "Insert Book":
                    library.add(commands[1]);
                    break;
                case "Check Book":
                    int index = Integer.parseInt(commands[1]);
                    if (index > library.size() || index <0) {
                        break;
                    } else {
                        System.out.println(library.get(index));
                        break;
                    }
            }


            commands = Arrays.stream(scanner.nextLine().split("\\|"))
                    .map(String::trim)
                    .toArray(String[]::new);
        }
        for (int i = 0; i < library.size(); i++) {
            if (i < library.size() - 1) {
                System.out.print(library.get(i) + ", ");
            } else {
                System.out.println(library.get(i));

            }
        }
    }
}
