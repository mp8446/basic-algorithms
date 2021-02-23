package com.petersen;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        Sorting<Integer> sorting = new Sorting<>();

        for (int i = 0; i < 1000; i++) {
            sorting.addElement(ThreadLocalRandom.current().nextInt(0, 1000));
        }

        //Test the sorting
        sorting.bubbleSort();

        System.out.println(sorting);
    }

}
