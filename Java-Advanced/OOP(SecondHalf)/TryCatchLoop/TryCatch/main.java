package TryCatch;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validation = true;
        while (validation) {
            try {

                int start = Integer.parseInt(scanner.nextLine());
                int end = Integer.parseInt(scanner.nextLine());
                invalidNumber(start, end);
                printNumbers(start, end);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());


            }
        }
        
    }

    private static void printNumbers(int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.println(i);
        }
    }

    static void invalidNumber(int start, int end) {
        if (start < 1 || start >= end || end > 100) {
            throw new IllegalArgumentException("Try another numbers");
        }

    }
}
