package InterfaceAndAbstraction.Telephony;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> urls = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone(numbers,urls);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());

    }
}
