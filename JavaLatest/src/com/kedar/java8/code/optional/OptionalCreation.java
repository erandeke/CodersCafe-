package com.kedar.java8.code.optional;

import java.util.Optional;

/**
 * @author Kedar Erande
 */
public class OptionalCreation {
    public static void main(String[] args) {
        Optional<Integer> opt = Optional.of(10);
        System.out.println(opt.get());

        String s1 = "value";
        String s2 = null;

        System.out.println("s1 value is" + Optional.ofNullable(s1)); // value
        System.out.println("s1 value is" + Optional.ofNullable(s2)); //Optional.empty

        Optional<String> op = null;

        //System.out.println("Null Pointer exceptopn" + op.get()); //NPE

        //isPresent

        //Before Optional

        String name = "Kedar";
        if (null != null) {
            System.out.println(name);
        }

        //After Optional

        Optional<String> userName = Optional.of("Kedar");
        userName.ifPresent(s -> System.out.println(s));

        //orElse
        String lastName = null;
        String lastNameActual = Optional.ofNullable(lastName).orElseGet(() -> "Erande");
        System.out.println(lastNameActual);


    }
}
