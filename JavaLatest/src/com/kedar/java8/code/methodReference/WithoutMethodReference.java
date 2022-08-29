package com.kedar.java8.code.methodReference;

/**
 * @author Kedar Erande
 */
public class WithoutMethodReference {
    public static void main(String[] args) {
        Follow follow = new Follow();
        Followers f = () -> follow.showFollowers();
        f.showFollowers();
    }
}
