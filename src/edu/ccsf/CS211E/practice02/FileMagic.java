package edu.ccsf.CS211E.practice02;

import java.io.*;
import java.util.Scanner;

public class FileMagic {

    public static void main(String[] args) {
        // File names (Assuming file1.txt is placed correctly as per project structure)
        // You can adjust the file path based on where file1.txt is located in your project

        // If file1.txt is in the same directory as the .class file or root directory (for plain Java projects):
        // String inputFileName = "file1.txt";

        // If file1.txt is in a resources directory (for IntelliJ IDEA, Eclipse, or Maven projects):
        String inputFileName = "file1.txt";
        String outputFileName = "file2.txt";

        // Initialize word count
        int wordCount = 0;

        // StringBuilder to hold the modified content
        StringBuilder modifiedContent = new StringBuilder();

        // Reading the file using the ClassLoader (for projects using resources directories)
        try {
            // For IntelliJ IDEA, Eclipse, or Maven: Use ClassLoader to access the file
            InputStream inputStream = FileMagic.class.getClassLoader().getResourceAsStream(inputFileName);

            if (inputStream != null) {
                // Use Scanner to read from the InputStream
                try (Scanner scanner = new Scanner(new InputStreamReader(inputStream))) {
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
                }
            } else {
                System.out.println("File not found!");
                return;
            }

            // Display the word count
            System.out.println("The number of words in the file: " + wordCount);

            // Write the modified content to the output file (file2.txt)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                writer.write(modifiedContent.toString());
            }

            // Display the contents of the output file (file2.txt)
            System.out.println("Modified text in " + outputFileName + ":");
            try (BufferedReader reader = new BufferedReader(new FileReader(outputFileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

