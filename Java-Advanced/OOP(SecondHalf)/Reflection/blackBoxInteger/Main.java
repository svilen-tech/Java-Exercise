package blackBoxInteger;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Constructor<BlackBoxInt> ctor = BlackBoxInt.class.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();
        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            int param = Integer.parseInt(tokens[1]);
            String command = tokens[0];
            Method method = Arrays.stream(methods).filter(m -> m.getName().equals(command)).findFirst().get();
            method.setAccessible(true);
            method.invoke(blackBoxInt, param);

            System.out.println(innerValue.getInt(blackBoxInt));
        }
    }
}
