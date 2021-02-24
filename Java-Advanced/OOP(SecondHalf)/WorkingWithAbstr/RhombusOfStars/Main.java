package WorkingWithAbstraction.RhombusOfStars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int k = 1;
        for (int i = 0; i < n; i++) {
            printRow(n-k," ");
            printRow(k,"* ");
            System.out.println();
            k++;
        }
        k = 1;
        for (int i = 0; i < n - 1; i++) {
            printRow(k, " ");
            printRow(n - k, "* ");
            System.out.println();
            k++;
        }

    }

    public static void printRow(int k, String param) {
        for (int j = 0; j < k; j++) {
            System.out.print(param);
        }
    }

}
