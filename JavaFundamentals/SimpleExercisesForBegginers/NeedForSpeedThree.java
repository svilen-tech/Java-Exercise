package com.company;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NeedForSpeedThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] line = input.split(" ");
        int[] array = new int[line.length];
        for (int i = 0; i < line.length ; i++) {
            array[i] = Integer.parseInt(line[i]);
        }

        double sum =0;
        for (int i = 0; i <array.length ; i++) {
            sum = sum+array[i];
        }
        double average = sum/array.length;

        List<Integer> aboveAverage = new ArrayList<>();
        for (Integer integer : array) {
            if (integer>average) {
                aboveAverage.add(integer);
            }
        }


        if (aboveAverage.isEmpty()) {
            System.out.println("No");
        }else {
            Collections.sort(aboveAverage);
            Collections.reverse(aboveAverage);
            for (int i = 0; i < Math.min(aboveAverage.size(), 5); i++) {
                System.out.print(aboveAverage.get(i)+" ");
            }
        }

    }
}
