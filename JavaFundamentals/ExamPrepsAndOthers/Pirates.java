package FinalExamPreparation;

import java.lang.reflect.Array;
import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> citiesOnMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while(!input.equals("Sail")){
            String[] commands = input.trim().split("\\|\\|");
            String name = commands[0];
            int population = Integer.parseInt(commands[1]);
            int gold = Integer.parseInt(commands[2]);
            if (!citiesOnMap.containsKey(name)){
                citiesOnMap.put(name,new ArrayList<>());
                citiesOnMap.get(name).add(population);
                citiesOnMap.get(name).add(gold);
            }else{
                int addedPop = citiesOnMap.get(name).get(0)+population;
                int addedGold =citiesOnMap.get(name).get(1)+gold;
                citiesOnMap.get(name).set(0,addedPop);
                citiesOnMap.get(name).set(1,addedGold);
            }


            input= scanner.nextLine();
        }
        String neuInput = scanner.nextLine();
        while (!neuInput.equals("End")){
            String[] commands = neuInput.split("=>");
            String possibleCase = commands[0];
            String town = commands[1];
            switch (possibleCase) {

                case "Plunder":
                    int people = Integer.parseInt(commands[2]);
                    int gold = Integer.parseInt(commands[3]);
                    int tempPopulation = citiesOnMap.get(town).get(0) - people;
                    int tempGold = citiesOnMap.get(town).get(1) - gold;
                    System.out.printf("%s plundered! %d gold stolen, %s citizens killed.%n", town, gold, people);
                    if (tempPopulation <= 0 || tempGold <= 0) {
                        citiesOnMap.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }else{
                        citiesOnMap.get(town).set(1,tempGold);
                        citiesOnMap.get(town).set(0,tempPopulation);
                    }
                    break;
                case"Prosper":
                    int prosperGold = Integer.parseInt(commands[2]);
                    if (prosperGold<0){
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    }else{
                        int goldReplacement =citiesOnMap.get(town).get(1)+prosperGold;
                        citiesOnMap.get(town).set(1,goldReplacement);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",prosperGold,town,goldReplacement);
                    }
                    break;
            }

            neuInput = scanner.nextLine();
        }
        if (citiesOnMap.size() > 0) {


            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesOnMap.size());
            citiesOnMap.entrySet().stream()
                    .sorted((a, b) -> {
                        int result = b.getValue().get(1) - a.getValue().get(1);
                        if (result == 0) {
                            result = a.getKey().compareTo(b.getKey());
                        }
                        return result;
                    }).forEach(h -> {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", h.getKey(), h.getValue().get(0), h.getValue().get(1));

            });
        }else{
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }


    }
}






















//   Map<String, List<Integer>> citiesOnMap = new LinkedHashMap<>();
//        String input = scanner.nextLine();
//        while(!input.equals("Sail")){
//            String[]citiesAndGold = input.split("\\|\\|");
//            String city = citiesAndGold[0];
//            int population = Integer.parseInt(citiesAndGold[1]);
//            int gold = Integer.parseInt(citiesAndGold[2]);
//            if (!citiesOnMap.containsKey(city)){
//                citiesOnMap.put(city,new ArrayList<>());
//                citiesOnMap.get(city).add(population);
//                citiesOnMap.get(city).add(gold);
//            }else{
//                int tempPop = citiesOnMap.get(city).get(0)+population;
//                int tempGold = citiesOnMap.get(city).get(1)+gold;
//                citiesOnMap.get(city).set(0,tempPop);
//                citiesOnMap.get(city).set(1,tempGold);
//            }
//            input = scanner.nextLine();
//        }
//        String events = scanner.nextLine();
//        while(!events.equals("End")){
//            String[] commands = events.split("=>");
//            String type = commands[0];
//            String town = commands[1];
//            if (type.equals("Plunder")){
//                int peopleToKill = Integer.parseInt(commands[2]);
//                int goldToSteal = Integer.parseInt(commands[3]);
//                int tempPop = citiesOnMap.get(town).get(0)-peopleToKill;
//                int tempGold = citiesOnMap.get(town).get(1)-goldToSteal;
//                if (tempPop<=0||tempGold<=0){
//                    citiesOnMap.remove(town);
//                    System.out.printf("%s has been wiped off the map!",town);
//                }else{
//                    citiesOnMap.get(town).set(0,tempPop);
//                    citiesOnMap.get(town).set(1,tempGold);
//                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.",town,goldToSteal,peopleToKill);
//                }
//
//            }else if(type.equals("Prosper")){
//                int gold =Integer.parseInt(commands[2]);
//                if (gold<0){
//                    System.out.println("Gold added cannot be a negative number!");
//                }else{
//                    int te = citiesOnMap.get(town).get(1)+gold;
//                    citiesOnMap.get(town).set(1,te);
//                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.",gold,town,te);
//                }
//
//
//            }
//
//
//
//        }