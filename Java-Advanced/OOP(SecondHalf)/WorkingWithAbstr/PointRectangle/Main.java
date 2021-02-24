package WorkingWithAbstraction.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Point first = new Point(size[0], size[1]);
        Point second = new Point(size[2], size[3]);
        Rectangle rectangle = new Rectangle(first, second);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] sides = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = sides[0];
            int y = sides[1];
            System.out.println(rectangle.contains(x, y));
        }
    }
}
