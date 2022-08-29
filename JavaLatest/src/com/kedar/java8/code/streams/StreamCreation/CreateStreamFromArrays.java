package com.kedar.java8.code.streams.StreamCreation;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Kedar Erande
 */
public class CreateStreamFromArrays {
    public static void main(String[] args) {

        String arr[] = {"a", "b", "c", "d"};
        Stream<String> stream = Arrays.stream(arr);
        stream.forEach(s -> System.out.println(s));

        Integer intArray[] = {1, 20, 40};
        Stream<Integer> stream1 = Arrays.stream(intArray);
        stream1.forEach(s -> System.out.println(s));

    }
}
