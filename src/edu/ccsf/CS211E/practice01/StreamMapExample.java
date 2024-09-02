/**
 * @author Charles Tang
 * @course CS211E
 * @professor Anita Rathi
 * @semeter Fall
 * @year 2024
 */

package edu.ccsf.CS211E.practice01;

import java.util.stream.IntStream;

public class StreamMapExample {
    public static void main(String[] args) throws java.lang.Exception {
        // sample numbers array
        int arr[] = {3, 4, 5, 6, 7};

        // each number increase by 1
        IntStream.of(arr)
            .map(j -> j + 1)
            .forEach(System.out::println);
    }
}
