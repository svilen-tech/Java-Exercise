package Encapsulation.FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input =scanner.nextLine();
        Map<String,Team> teams = new LinkedHashMap<>();


        while (!input.equals("END")){
            String[]typeCommands = input.split(";");
            if (typeCommands[0].equals("Team")){
                Team team = new Team(typeCommands[1]);
                teams.put(typeCommands[1],team);
            }else if (typeCommands[0].equals("Add")){
                addingPlayer(typeCommands,teams);
            }else if (typeCommands[0].equals("Remove")){
                teams.get(typeCommands[1]).removePlayer(typeCommands[2]);
            }else if (typeCommands[0].equals("Rating")){
                int rating = (int)teams.get(typeCommands[1]).getRating();
                System.out.println(typeCommands[1]+" - "+rating);
            }
            input=scanner.nextLine();
        }
    }

    private static void addingPlayer(String[] input,Map<String,Team>teamMap) {
        String teamName=input[1];
        String playerName=input[2];
        int endurance =Integer.parseInt(input[3]);
        int sprint =Integer.parseInt(input[4]);
        int dribble =Integer.parseInt(input[5]);
        int passing =Integer.parseInt(input[6]);
        int shooting =Integer.parseInt(input[7]);
        Player player = new Player(playerName,endurance,sprint,dribble,passing,shooting);
        if (teamMap.containsKey(teamName)){
            teamMap.get(teamName).addPlayer(player);
        }else{
            System.out.printf("Team %s does not exist.%n",teamName);
        }
    }
}
