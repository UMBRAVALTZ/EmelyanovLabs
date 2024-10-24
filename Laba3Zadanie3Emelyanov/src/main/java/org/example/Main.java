package org.example;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Main <path_to_class_file> <num1> <num2>");
            return;
        }

        String classPath = args[0];
        Integer num1 = Integer.parseInt(args[1]);
        Integer num2 = Integer.parseInt(args[2]);

        CustomClassLoader customClassLoader = new CustomClassLoader(classPath);
        try {
            // Загружаем класс
            Class<?> clazz = customClassLoader.loadClass("org.example.BiFunc");
            // Приводим к интерфейсу
            BiFunction<Integer, Integer, Integer> biFunction =
                    (BiFunction<Integer, Integer, Integer>) clazz.getDeclaredConstructor().newInstance();
            // Вызываем метод apply
            Integer result = biFunction.apply(num1, num2);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}