package com.kedar.concurrency.thread.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/*
 if (list.size() <= 1) return list;

        int mid = (list.size()) / 2;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();


        for (int i = 0; i < mid; i++) {
            left.add(list.get(i));
        }


        for (int j = mid; j < list.size(); j++) {
            right.add(list.get(j));
        }

        //call recursively this task


        Future<List<Integer>> sortedLeft = executorService.submit(new Sorter(left, executorService));
        Future<List<Integer>> sortedRight = executorService.submit(new Sorter(right, executorService));
        List<Integer> leftArray = sortedLeft.get();
        System.out.println(leftArray + "Print left sorted array ");

        List<Integer> rightArray = sortedRight.get();
        System.out.println(leftArray + "Print right sorted array ");


        List<Integer> finalList = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i) < rightArray.get(j)) {
                finalList.add(leftArray.get(i));
                i++;
            } else {
                finalList.add(rightArray.get(j));
                j++;
            }
        }

        while (i < leftArray.size()) {
            finalList.add(leftArray.get(i));
            i++;
        }

        while (j < rightArray.size()) {
            finalList.add(rightArray.get(j));
            j++;
        }

        return finalList;
 */
public class Sorter implements Callable {

    List<Integer> list;
    ExecutorService executorService;

    public Sorter(List<Integer> list, ExecutorService executorService) {
        this.list = list;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws ExecutionException, InterruptedException {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            left.add(list.get(i));
        }

        for (int i = mid; i < list.size(); i++) {
            right.add(list.get(i));
        }

        Future<List<Integer>> sortedLeft = executorService.submit(new Sorter(left, executorService));
        Future<List<Integer>> sortedRight = executorService.submit(new Sorter(right, executorService));

        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        List<Integer> leftArray = sortedLeft.get();
        System.out.println("Here is the sorted left array " + leftArray);
        List<Integer> rightArray = sortedRight.get();
        System.out.println("Here is the sorted right array " + rightArray);

        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i) < rightArray.get(j)) {
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

        return result;
    }
}
