package org.example;

import java.util.function.BiFunction;

public class BiFunc implements BiFunction<Integer, Integer, Integer> {
    @Override
    public Integer apply(Integer num1, Integer num2) {
        return num1 + num2;
    }
}
