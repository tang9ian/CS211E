/**
 * @author Charles Tang
 * @course CS211E
 * @professor Anita Rathi
 * @semeter Fall
 * @year 2024
 */

package edu.ccsf.CS211E.homework01;

import java.util.Scanner;

public class StreamsExample {
    // core of count method for the input string.
    public static long countOccurs(String str, char c) {
        return str.chars()
            .filter(ch -> ch == c)
            .count();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // prompt the user to type a string.
        System.out.print("Enter your string: "); // such as "seedsandseeds", or "abccdefgaa" and so on...
        String str = scanner.nextLine();

        // prompt the user to type a character to count.
        System.out.print("Enter which character to count: "); // such as 'e' or 'a' and so on...
        char c = scanner.next().charAt(0);

        System.out.println("The character " + c + " appears " + countOccurs(str, c) + " times in \"" + str + "\".");
        // System.out.println("'" + c + "' appears " + countOccurs(str, c) + " times in str."); // for the assigment requires output.

        // terminate the scanner
        scanner.close();
    }
}
