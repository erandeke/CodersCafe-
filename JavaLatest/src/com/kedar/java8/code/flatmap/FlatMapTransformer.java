package com.kedar.java8.code.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class FlatMapTransformer {
    public static void main(String[] args) {
        Employee employee = new Employee(1, Arrays.asList(new Address(1, "Pune"), new Address(2, "Mumbai")));
        Employee employee1 = new Employee(3, Arrays.asList(new Address(1, "Pune"), new Address(2, "Delhi")));
        Employee employee3 = new Employee(2, Arrays.asList(new Address(1, "Pune"), new Address(2, "Mumbai")));


    }
}
