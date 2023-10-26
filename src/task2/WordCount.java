package task2;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import java.util.*;
import java.io.*;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Word Counter!");
        System.out.println("Enter '1' to input text, or '2' to provide a file for counting words:");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        String text = "";

        if (choice == 1) {
            System.out.println("Enter the text to count words:");
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.print("Enter the file name (including path): ");
            String fileName = scanner.nextLine();
            
            try {
                text = readFile(fileName);
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
                return;
            }
        } else {
            System.out.println("Invalid choice. Please select '1' or '2'.");
            return;
        }

        // Split text into words using space and punctuation as delimiters
        String[] words = text.split("[\\s\\p{Punct}]+");
        
        // Initialize a counter variable
        int wordCount = words.length;

        System.out.println("Total word count: " + wordCount);

        // Option to ignore common words
        System.out.println("Do you want to ignore common words (stop words)? (yes/no)");
        String ignoreCommonWords = scanner.nextLine();

        if (ignoreCommonWords.equalsIgnoreCase("yes")) {
            // List of common words to ignore
            List<String> commonWords = Arrays.asList("the", "and", "is", "in", "on", "at", "to", "of", "a");

            // Filter out common words
            words = Arrays.stream(words)
                    .filter(word -> !commonWords.contains(word.toLowerCase()))
                    .toArray(String[]::new);

            wordCount = words.length;
            System.out.println("Total word count (excluding common words): " + wordCount);
        }

        // Word frequency statistics
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // Display word frequency statistics
        System.out.println("Word Frequency Statistics:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Read a file and return its contents as a string
    private static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line).append(" ");
        }

        reader.close();
        return content.toString();
    }
}
