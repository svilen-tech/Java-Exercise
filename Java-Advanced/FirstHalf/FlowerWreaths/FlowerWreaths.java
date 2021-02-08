package examPreparation.nineteenAugust;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();

        int[] firstStack = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .toArray();
        int[] secondStack = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .toArray();

        int wreaths=0;

        for (int i = 0; i <firstStack.length ; i++) {
            lilies.push(firstStack[i]);
        }
        for (int i = secondStack.length-1; i >=0 ; i--) {
            roses.push(secondStack[i]);
        }
        int valueLilies = 0;
        int sumForLater =0;
        while (!lilies.isEmpty()&&!roses.isEmpty()){
            int valueRose = roses.peek();
            if (valueLilies==0) {
                valueLilies = lilies.peek();
            }
            int sum = valueLilies+valueRose;
            if (sum==15){
                wreaths++;
                roses.pop();
                lilies.pop();
                valueLilies=0;
            }else if (sum>15){
                valueLilies-=2;
            }else if (sum<15){
                sumForLater+=sum;
                roses.pop();
                lilies.pop();
                valueLilies=0;
            }
        }
        System.out.println();
        int moreWreaths =sumForLater/15;
        int totalWreaths =moreWreaths+wreaths;
       if (totalWreaths>=5){
           System.out.printf("You made it, you are going to the competition with %d wreaths!",totalWreaths);
       }else{
           System.out.printf("You didn't make it, you need %d wreaths more!",5-totalWreaths);
       }
    }
}
