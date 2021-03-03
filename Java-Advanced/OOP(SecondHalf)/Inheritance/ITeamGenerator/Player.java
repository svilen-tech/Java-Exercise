package Encapsulation.FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;
    public Player(String name,int endurance,int sprint,int dribble,int passing,int shooting){
     this.setName(name);
     this.setEndurance(endurance);
     this.setSprint(sprint);
     this.setDribble(dribble);
     this.setPassing(passing);
     this.setShooting(shooting);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (checkNumbers(endurance)) {
            System.out.println("Endurance should be between 0 and 100.");
        } else {
            this.endurance = endurance;
        }
    }

    private void setSprint(int sprint) {
        if (checkNumbers(sprint)){
            System.out.println("Sprint should be between 0 and 100.");
        }else {
            this.sprint = sprint;
        }
    }

    private void setDribble(int dribble) {
        if (checkNumbers(dribble)) {
            System.out.println("Dribble should be between 0 and 100.");
        } else {
            this.dribble = dribble;
        }
    }

    private void setPassing(int passing) {
        if (checkNumbers(passing)) {
            System.out.println("Passing should be between 0 and 100.");
        } else {
            this.passing = passing;
        }
    }

    private void setShooting(int shooting) {
        if (checkNumbers(shooting)) {
            System.out.println("Shooting should be between 0 and 100.");
        } else {
            this.shooting = shooting;
        }
    }

    public String getName() {
        return name;
    }public double overallSkillLevel(){
        double result = Math.round((endurance+sprint+dribble+passing+shooting)/5.0);
        return result;
    }
    private boolean checkNumbers(int num){
        return num < 0 || num > 100;
    }
}
