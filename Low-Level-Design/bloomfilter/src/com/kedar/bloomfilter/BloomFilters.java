package com.kedar.bloomfilter;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class BloomFilters {
    public final static int No_OF_BITS = 1000;
    final static HashFunction h1 = new HashFunction(11, 9);
    final static HashFunction h2 = new HashFunction(17, 15);
    final static HashFunction h3 = new HashFunction(31, 29);
    final static HashFunction h4 = new HashFunction(61, 59);


    public static void main(String[] args) {
        BitSet bitSet = new BitSet(No_OF_BITS);

        //read the words ins list

        List<String> dictionary = new ArrayList<>();
        URL fileName = BloomFilters.class.getResource("words.txt");

        try {
            Stream<String> streamOfWords = Files.lines(Paths.get(fileName.getFile()));
            {
                streamOfWords.forEach(word -> dictionary.add(word));
            }
        } catch (IOException e) {
            System.out.println("Exception occurred while reading from the stream of file " + e);
        }

        //generate bloom filter for  all  words in dictionary
        for (int index = 0; index < dictionary.size(); index++) {
            String word = dictionary.get(index);
            //pass it to hash functions
            bitSet.set(h1.getHashValue(word));
            bitSet.set(h2.getHashValue(word));
            bitSet.set(h3.getHashValue(word));
            bitSet.set(h4.getHashValue(word));
        }


        //check if the word is present

        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        boolean isUserNamePresent = bitSet.get(h1.getHashValue(userName)) && bitSet.get(h2.getHashValue(userName)) && bitSet.get(h3.getHashValue(userName)) && bitSet.get(h4.getHashValue(userName));
        System.out.println("Checking-----------------------------");
        System.out.println("BloomFilter answer is " + isUserNamePresent);
        if (!isUserNamePresent) {
            System.out.println("Username is available");
        } else {
            System.out.println("Username is taken");
        }
    }


    private static class HashFunction {
        private long prime;
        private long odd;

        public HashFunction(long prime, long odd) {
            this.prime = prime;
            this.odd = odd;
        }

        public int getHashValue(final String word) {
            int hash = word.hashCode();
            if (hash < 0) {
                hash = Math.abs(hash);
            }
            return calculateHash(hash, prime, odd);
        }

        private int calculateHash(final int hash, final long prime, final long odd) {
            return (int) (((((hash % No_OF_BITS) * prime) % No_OF_BITS) * odd) % No_OF_BITS);
        }


    }

}
