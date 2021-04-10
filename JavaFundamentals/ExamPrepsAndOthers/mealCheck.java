package FinalExamPreparation;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class mealCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> guestsAndMeals = new HashMap<>();
        String input = scanner.nextLine();
        int unlikeMeals = 0;
        while (!input.equals("Stop")) {
            String[] commands = input.split("-");
            String type = commands[0];
            String guest = commands[1];
            String meal = commands[2];
            switch (type) {
                case "Like":
                    if (!guestsAndMeals.containsKey(guest)) {
                        guestsAndMeals.put(guest, new ArrayList<>());
                        guestsAndMeals.get(guest).add(meal);
                    } else {
                        if (!guestsAndMeals.get(guest).contains(meal)) {
                            guestsAndMeals.get(guest).add(meal);
                        }
                    }

                    break;
                case "Unlike":
                    if (guestsAndMeals.containsKey(guest) && guestsAndMeals.get(guest).contains(meal)) {
                        guestsAndMeals.get(guest).remove(meal);
                        System.out.printf("%s doesn't like the %s.%n", guest, meal);
                        unlikeMeals++;
                    } else if (!guestsAndMeals.containsKey(guest)) {
                        System.out.printf("%s is not at the party.%n", guest);
                    } else if (!guestsAndMeals.get(guest).contains(meal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
  guestsAndMeals.entrySet().stream()
                .sorted((a, b) -> {
                    int result = b.getValue().size() - a.getValue().size();
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;


                }).forEach(g->{
      System.out.print(g.getKey()+": ");
      for (int i = 0; i <g.getValue().size() ; i++) {
          String valu = g.getValue().get(i);
          if ((i<g.getValue().size()-1)) {
              System.out.print(valu.replaceAll("\\[", "") + ", ");
          }else{
              System.out.print(valu.replaceAll("\\[", ""));
          }
      }
      System.out.println();
  });
        System.out.println("Unliked meals: "+unlikeMeals);

    }
}





