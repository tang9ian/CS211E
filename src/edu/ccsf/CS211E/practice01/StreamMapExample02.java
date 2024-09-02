/**
 * @author Charles Tang
 * @course CS211E
 * @professor Anita Rathi
 * @semeter Fall
 * @year 2024
 */
package edu.ccsf.CS211E.practice01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapExample02 {
    public static void main(String[] args) {
        // Sample list of names
        List<String> names = Arrays.asList("tom", "mark", "nick");

        // Using map() to convert each name to uppercase
        List<String> upperCaseNames = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        // Printing the result
        System.out.println(upperCaseNames);
    }
}