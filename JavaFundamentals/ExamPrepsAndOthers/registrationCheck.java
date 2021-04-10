package FinalExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registrationCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String reg = "U\\$(?<username>[A-Z][a-z]{2,})U\\$P\\@\\$(?<password>[A-Za-z]{5,}[1-9]{1,})P\\@\\$";
        Pattern pattern = Pattern.compile(reg);
     int countRegis = 0;
        for (int i = 0; i <n ; i++) {

            String registration = scanner.nextLine();
            Matcher matcher = pattern.matcher(registration);
            if (matcher.find()){
                String name = matcher.group("username");
                String password = matcher.group("password");
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n",name,password);
                countRegis++;
            }else{
                System.out.println("Invalid username or password");
            }
        }
        System.out.println("Successful registrations: "+countRegis);
    }
}
