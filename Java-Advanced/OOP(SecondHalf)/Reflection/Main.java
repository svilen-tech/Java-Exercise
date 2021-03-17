package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Ref;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)  {
        Field[] fields = Reflection.class.getDeclaredFields();
        Arrays.stream(fields)
                .filter(f->!Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f-> System.out.printf("%s must be private!%n",f.getName()));
        Method[] method = Reflection.class.getDeclaredMethods();
        Arrays.stream(method)
                .filter(f->f.getName().startsWith("get")&&f.getParameterCount()==0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(f-> System.out.printf("%s have to be public!%n",f.getName()));

        Arrays.stream(method)
                .filter(f->f.getName().startsWith("set")&&f.getParameterCount()==0)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(f-> System.out.printf("%s have to be public!%n",f.getName()));
    }
}
