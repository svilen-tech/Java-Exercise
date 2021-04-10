package FinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String>firstMirror = new ArrayList<>();
        List<String>secondMirror = new ArrayList<>();
        String text = scanner.nextLine();
        int pairs = 0;
        String regex = "([#@])(?<first>[A-Za-z]{3,})\\1{2}(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            pairs++;
            String k = matcher.group("second");
            StringBuilder sb = new StringBuilder(k);
            sb.reverse();
            k = sb.toString();
            if (matcher.group("first").equals(k)){
                firstMirror.add(matcher.group("first"));
                secondMirror.add(matcher.group("second"));
            }
        }
        if (pairs!=0){
            System.out.printf("%d word pairs found!%n",pairs);
        }else{
            System.out.println("No word pairs found!");
        }

        if (!firstMirror.isEmpty()){
            System.out.println("The mirror words are:");
            for (int i = 0; i < firstMirror.size(); i++) {
                if (i<firstMirror.size()-1) {
                    System.out.print(firstMirror.get(i) + " <=> " + secondMirror.get(i)+", ");
                }else{
                    System.out.println(firstMirror.get(i) + " <=> " + secondMirror.get(i));
                }
            }
        }else{
            System.out.println("No mirror words!");
        }

    }
}
