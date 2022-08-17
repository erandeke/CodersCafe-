package com.kedar.concurrency.thread.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Need to correct this algorithm  - Not correct

public class MergeSortSequential {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            arr.add(random.nextInt(10));
        }

        int i = 0;
        int j = 0;
        int length = arr.size();
        int mid = length / 2;

        for (int k = 0; k < mid; k++) {
            leftArray.add(arr.get(k));
        }

        for (int p = mid; p < length; p++) {
            rightArray.add(arr.get(p));
        }

        System.out.println("Left array is " + leftArray);
        System.out.println("right array is " + rightArray);

        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                result.add(leftArray.get(i));
                i++;
            } else {
                result.add(rightArray.get(j));
                j++;
            }

        }
        while (i < leftArray.size()) {
            result.add(leftArray.get(i));
            i++;
        }

        while (j < rightArray.size()) {
            result.add(rightArray.get(j));
            j++;
        }
        System.out.println(result);
    }
}
