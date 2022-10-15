package com.example;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayPrinter {
    private int[][] array;
    private final Set<Integer> linkedHashSet = new LinkedHashSet<>();

    public void print(int[][] arr) {
        array = arr;

        int rightIndex = 0;
        int downIndex = array.length - 1;
        int leftIndex = array[0].length - 1;
        int upIndex = 0;

        while (rightIndex < array.length) {
            right(rightIndex++);
            down(downIndex--);
            left(leftIndex--);
            up(upIndex++);
        }

        StringBuilder sb = new StringBuilder();
        linkedHashSet.forEach(integer -> sb.append(integer).append(","));
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private void right(int i) {
        Arrays.stream(array[i]).forEach(linkedHashSet::add);
    }

    private void down(int i) {
        Arrays.stream(array).forEach(ints -> {
            linkedHashSet.add(ints[i]);
        });
    }

    private void left(int index) {
        for (int i = array[index].length - 1; i >= 0; i--) {
            linkedHashSet.add(array[index][i]);
        }
    }

    private void up(int index) {
        for (int i = array.length - 1; i >= 0; i--) {
            linkedHashSet.add(array[i][index]);
        }
    }

}
