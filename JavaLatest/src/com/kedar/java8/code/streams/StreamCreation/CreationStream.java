package com.kedar.java8.code.streams.StreamCreation;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Kedar Erande
 * <p>
 * Create stream from collection
 */
public class CreationStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Stream<Integer> stream = list.stream();
        stream.forEach(s -> System.out.println(s));

        Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = collection.stream();
        stream1.forEach(s -> System.out.println(s));


    }
}
