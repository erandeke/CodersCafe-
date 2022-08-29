package com.kedar.java8.code.methodReference;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Kedar Erande
 */

interface Followers {
    void showFollowers();
}

class Follow implements Followers {

    @Override
    public void showFollowers() {
        System.out.println(Arrays.asList(1, 2, 3));
    }

    public static void main(String[] args) {
        Follow follow = new Follow();
        Followers followers = follow::showFollowers;
        followers.showFollowers();
    }
}