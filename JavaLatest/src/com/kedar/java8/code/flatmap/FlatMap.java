package com.kedar.java8.code.flatmap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kedar Erande
 */
public class FlatMap {
    public static void main(String[] args) {
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);

        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfInts = Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
        System.out.println("Merge list" + listOfInts);

        //flat map : It is the combination of map and flat . It first applies the map function and
        //then performs the flattening of the string
        List<Integer> list = listOfInts.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        System.out.println("List" + list);

    }
}
