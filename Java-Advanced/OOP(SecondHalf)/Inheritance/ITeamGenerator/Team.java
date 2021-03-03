package Encapsulation.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name){
        this.setName(name);
        this.players=new ArrayList<>();
    }
    private void setName(String name){
        if (name==null||name.trim().isEmpty()){
            throw new IllegalArgumentException(name+" should not be empty.");
        }
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public void addPlayer(Player player){

        players.add(player);
    }
    public void removePlayer(String name){
        boolean removed= true;
        for (int i = 0; i <players.size() ; i++) {
            if (players.get(i).getName().equals(name)){
                players.remove(i);
                removed=false; }

        }
        if (removed){
            System.out.printf("Player %s is not in the %s team.%n",name,getName());
        }

    }
    public double getRating(){
        double rating=0.0;
        for (int i = 0; i <players.size() ; i++) {
           rating+= players.get(i).overallSkillLevel();
        }
        return rating;
    }
}
