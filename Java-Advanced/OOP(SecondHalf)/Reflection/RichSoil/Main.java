package harvestingFields;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		Field[] fields = RichSoilLand.class.getDeclaredFields();
		while (!input.equals("HARVEST")){

			switch (input){
				case "private":
                    Arrays.stream(fields)
                            .filter(f-> Modifier.isPrivate(f.getModifiers()))
                            .forEach(s-> System.out.printf("private %s %s%n",s.getType().getSimpleName(),s.getName()));
					break;
				case "protected":
					Arrays.stream(fields)
							.filter(f-> Modifier.isProtected(f.getModifiers()))
							.forEach(s-> System.out.printf("protected %s %s%n",s.getType().getSimpleName(),s.getName()));
					break;
				case "public":
                    Arrays.stream(fields)
                            .filter(f-> Modifier.isPublic(f.getModifiers()))
                            .forEach(s-> System.out.printf("public %s %s%n",s.getType().getSimpleName(),s.getName()));
					break;
				case "all":
                    Arrays.stream(fields)
                            .forEach(s-> System.out.printf("%s %s %s%n",Modifier.toString(s.getModifiers()),s.getType().getSimpleName(),s.getName()));
					break;
			}

			input = scanner.nextLine();
		}
	}
}
//private - print all private fields
// protected - print all protected fields
// public - print all public fields
// all - print ALL declared fields