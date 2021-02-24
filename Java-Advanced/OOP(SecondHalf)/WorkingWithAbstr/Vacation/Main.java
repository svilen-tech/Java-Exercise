package WorkingWithAbstraction.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        double price = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Calculator calculator = new Calculator(price,days
                ,Seasons.valueOf(input[2].toUpperCase()),input[3].equals("SecondVisit")?Discount.SECOND_VISIT :Discount.valueOf(input[3].toUpperCase()));


        System.out.printf("%.2f",calculator.makeTheBill());
    }
}
