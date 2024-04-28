import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = "";

        System.out.println("Welcome to Word Counter!");

        // Prompt the user to enter text or provide a file
        System.out.print("Enter text: ");
        String userInput = scanner.nextLine();

        try {
            // If the user input is a file path, read the file and store its contents in inputText
            File file = new File(userInput);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                inputText += fileScanner.nextLine() + " ";
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            // If the user input is not a file path, assume it's a text and use it directly
            inputText = userInput;
        }

        // Split the input text into an array of words using space or punctuation as delimiters
        String[] words = inputText.split("\\s+|\\p{Punct}");

        // Initialize variables
        int wordCount = 0;
        HashMap<String, Integer> wordFrequency = new HashMap<>();

        // Count words and calculate frequency
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }

        // Display total word count
        System.out.println("Total words: " + wordCount);

        // Display frequency of each word
        System.out.println("Word frequency:");
        for (String word : wordFrequency.keySet()) {
            System.out.println(word + ": " + wordFrequency.get(word));
        }

        scanner.close();
    }
}