package FinalExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> pieces = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String onePiece = input[0];
            String composer = input[1];
            String key = input[2];
            pieces.put(onePiece, new ArrayList<>());
            pieces.get(onePiece).add(composer);
            pieces.get(onePiece).add(key);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            String[] commands = input.split("\\|");
            String typeCom = commands[0];
            String piece = commands[1];
            switch (typeCom) {
                case "Add":
                    String composer = commands[2];
                    String key = commands[3];
                    if (pieces.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else if (!(pieces.containsKey(piece))) {
                        pieces.put(piece, new ArrayList<>());
                        pieces.get(piece).add(composer);
                        pieces.get(piece).add(key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = commands[2];
                    if (pieces.containsKey(piece)) {
                        pieces.get(piece).set(1, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;

            }


            input = scanner.nextLine();

        }

        pieces.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(kvp -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));


    }
}
