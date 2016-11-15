package com.sprilutsky.study;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by sergey on 16.11.16.
 */
public class FirstTask {

    private int sizeM;
    private int sizeN;
    private int rangeForRandom;

    public FirstTask(int sizeM, int sizeN, int rangeForRandom) {
        this.sizeM = sizeM;
        this.sizeN = sizeN;
        this.rangeForRandom = rangeForRandom;
    }

    public void run() {
        System.out.println("==========START FIRST TASK=========");
        // Init array
        int[][] arr = new int[sizeM][sizeN];

        Random random = new Random();
        Set<Integer> set = new HashSet<>();

        //Fill array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = random.nextInt(rangeForRandom);
            }
        }

        //Research array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int key = arr[i][j];
                if (!set.contains(key)) {
                    set.add(key);
                }
            }
        }
        //Output results
        System.out.println("Numbers of array: " + set.toString());
        System.out.println("Count different numbers: " + set.size());
        System.out.println("==========END FIRST TASK=========");
    }
}
