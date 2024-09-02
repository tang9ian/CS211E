/**
 * @author Charles Tang
 * @course CS211E
 * @professor Anita Rathi
 * @semeter Fall
 * @year 2024
 */

package edu.ccsf.CS211E.homework02;

import java.io.*;
import java.util.Scanner;

public class Assignment02 {
    public static void main(String[] args) {
        // File names
        String inputFileName = "file1.txt";
        String outputFileName = "file2.txt";

        // Initialize word count
        int wordCount = 0;

        // StringBuilder to hold the modified content
        StringBuilder modifiedContent = new StringBuilder();

        // Try-with-resources to handle file operations
        try (Scanner scanner = new Scanner(new File(inputFileName))) {
            while (scanner.hasNextLine()) {
                // Read each line from the file
                String line = scanner.nextLine();

                // Split the line into words
                String[] words = line.split("\\s+");

                // Update the word count
                wordCount += words.length;

                // Reverse each word and append to modifiedContent
                for (String word : words) {
                    modifiedContent.append(new StringBuilder(word).reverse().toString()).append(" ");
                }

                // Add a newline character to preserve the structure of the file
                modifiedContent.append(System.lineSeparator());
            }

            // Display the word count
            System.out.println("Number of words = " + wordCount);

            // Write the modified content to the output file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                writer.write(modifiedContent.toString());
            }

            // Display the contents of the output file
            System.out.println("Modified text in file2.txt:");
            try (BufferedReader reader = new BufferedReader(new FileReader(outputFileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
