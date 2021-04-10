package FinalExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "(@#+([A-Z]{1,}[a-z0-9A-Z]{4,}[A-Z]{1,})@#+)";
        String digitRegex ="\\d";
        Pattern pattern = Pattern.compile(regex);
        Pattern digPat = Pattern.compile(digitRegex);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            String strReg = scanner.nextLine();
            Matcher matcher = pattern.matcher(strReg);
            Matcher digMatch = digPat.matcher(strReg);
            String groupInDigits = "";
            if (matcher.find()){
                if (digMatch.find()) {
                    groupInDigits += digMatch.group();
                    while (digMatch.find()) {
                        groupInDigits += digMatch.group();
                    }

                }else{
                    groupInDigits ="00";
                }
                System.out.println("Product group: "+groupInDigits);
                groupInDigits= "00";

            }else {
                System.out.println("Invalid barcode");
            }


        }
    }
}
