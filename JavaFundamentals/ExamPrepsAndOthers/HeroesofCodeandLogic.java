package FinalExamPreparation;

import java.util.*;

public class HeroesofCodeandLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroes = new TreeMap<>();
        for (int i = 0; i <n ; i++) {
            String[]tempHero = scanner.nextLine().split(" ");
            String name = tempHero[0];
            int hp = Integer.parseInt(tempHero[1]);
            int mp = Integer.parseInt(tempHero[2]);
            heroes.put(name,new ArrayList<>());
            heroes.get(name).add(hp);
            heroes.get(name).add(mp);
        }
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] commands = input.split(" - ");
            String kommand = commands[0];
            String heroName = commands[1];
            if (kommand.equals("CastSpell")){
                int mpNeeded = Integer.parseInt(commands[2]);
                String spellName = commands[3];
                int checkMp = heroes.get(heroName).get(1)-mpNeeded;
                if (checkMp>0){
                    heroes.get(heroName).set(1,checkMp);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n",heroName,spellName,checkMp);
                }else{
                    System.out.printf("%s does not have enough MP to cast %s!%n",heroName,spellName);
                }
            }else if (kommand.equals("TakeDamage")){
                int damage = Integer.parseInt(commands[2]);
                String attacker = commands[3];
                int checkHp = heroes.get(heroName).get(0)-damage;
                if (checkHp>0){
                    heroes.get(heroName).set(0,checkHp);
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",heroName,damage,attacker,checkHp);
                }else{
                    heroes.remove(heroName);
                    System.out.printf("%s has been killed by %s!%n",heroName,attacker);
                }
            }else if (kommand.equals("Recharge")){
                int ammountRechargmana= Integer.parseInt(commands[2]);
                int test = heroes.get(heroName).get(1)+ammountRechargmana;
                int oldMana = heroes.get(heroName).get(1);
                int finAmm = test>200?200:test;
                oldMana = finAmm-oldMana;
                heroes.get(heroName).set(1,finAmm);
                System.out.printf("%s recharged for %d MP!%n",heroName,oldMana);
            }else if (kommand.equals("Heal")){
                int ammountForHeal = Integer.parseInt(commands[2]);
                int test = heroes.get(heroName).get(0)+ammountForHeal;
                int oldAmmount = heroes.get(heroName).get(0);
                int finAmm = test>100?100:test;
                oldAmmount = finAmm-oldAmmount;

                heroes.get(heroName).set(0,finAmm);
                System.out.printf("%s healed for %d HP!%n",heroName,oldAmmount);
            }


            input = scanner.nextLine();
        }
        heroes.entrySet().stream()
                .sorted((a,b)->{
                    int result = b.getValue().get(0)-a.getValue().get(0);
                    if (result==0){
                        result=a.getKey().compareTo(b.getKey());
                    }
                    return result;


        }).forEach(h->{
            System.out.println(h.getKey());
            System.out.println("  HP: "+ h.getValue().get(0));
            System.out.println("  MP: "+ h.getValue().get(1));
        });

    }
}
