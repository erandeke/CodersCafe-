package com.kedar.java8.code.lambda;

import com.kedar.java8.code.lambda.noparam.Walkable;

/**
 * @author Kedar Erande
 */
public class WalkImpl implements Walkable {
    @Override
    public void walk() {
        System.out.println("Lets walk");
    }
}
