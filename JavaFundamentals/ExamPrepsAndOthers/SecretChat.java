package FinalExamPreparation;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
      String input = scanner.nextLine();
        while (!input.equals("Reveal")){
            String[] commands = input.split(":\\|:");
            String tempCommand = commands[0];
            if (tempCommand.equals("InsertSpace")){
                int index = Integer.parseInt(commands[1]);
                StringBuilder sb = new StringBuilder(text);
                sb.insert(index," ");
                text = sb.toString();
                System.out.println(text);

            }else if (tempCommand.equals("Reverse")){
                String subStr = commands[1];
                if (text.contains(subStr)){
                    int startIndex = text.indexOf(subStr);
                    int endIndex = startIndex+subStr.length();
                    String toReverse = text.substring(startIndex,endIndex);
                    StringBuilder toRev = new StringBuilder(toReverse);
                    toRev.reverse();
                    String replaceMent = toRev.toString();
                    StringBuilder sb = new StringBuilder(text);
                    sb.delete(startIndex,endIndex);
                    sb.append(replaceMent);
                    text = sb.toString();
                    System.out.println(text);

                }else{
                    System.out.println("error");
                }
            }else if(tempCommand.equals("ChangeAll")){
                String subStr = commands[1];
                String replacement = commands[2];
               String k = text.replace(subStr,replacement);
               text = k;
                System.out.println(text);
            }


            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: "+text);
    }
}
