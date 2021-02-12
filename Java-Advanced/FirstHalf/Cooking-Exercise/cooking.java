package examPreparation.sixteenDecember;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class cooking {
    static int bread;
    static int cake;
    static int pastry;
    static int fruitPie;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputLiquid = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] inputIngredient = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stackLiquid = new ArrayDeque<>();
        ArrayDeque<Integer> stackIngredient = new ArrayDeque<>();

        for (int i = inputLiquid.length-1; i >=0 ; i--) {
            stackLiquid.push(inputLiquid[i]);
        }
        for (int i = 0; i <inputIngredient.length ; i++) {
            stackIngredient.push(inputIngredient[i]);
        }

        while (!stackIngredient.isEmpty()&&!stackLiquid.isEmpty()){

            int ingredient = stackIngredient.peek();
            int sumOfBoth =stackLiquid.pop()+ingredient;
            if (checkForBakery(sumOfBoth)){
                stackIngredient.pop();
            }else{
                stackIngredient.pop();
                stackIngredient.push(ingredient+3);

            }

        }
        if (bread!=0&&cake!=0&&pastry!=0&&fruitPie!=0){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        if (stackLiquid.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            StringBuilder sb = new StringBuilder();
            while (!stackLiquid.isEmpty()){
                sb.append(stackLiquid.pop()+", ");
            }
            System.out.println("Liquids left: "+sb.toString().substring(0,sb.length()-2));
        }
        if (stackIngredient.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            StringBuilder sb = new StringBuilder();
            while (!stackIngredient.isEmpty()){
                sb.append(stackIngredient.pop()+", ");
            }
            System.out.println("Ingredients left: "+sb.toString().substring(0,sb.length()-2));
        }

        System.out.printf("Bread: %d%nCake: %d%nFruit Pie: %d%nPastry: %d",bread,cake,fruitPie,pastry);

    }

    private static boolean checkForBakery(int sumOfBoth) {
        switch (sumOfBoth) {
            case 25:
                bread++;
                return true;
            case 50:
                cake++;
                return true;
            case 75:
                pastry++;
                return true;
            case 100:
                fruitPie++;
                return true;
            default:
                return false;
        }
    }
}
