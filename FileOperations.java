import java.io.*;
import java.util.Scanner;

public class FileOperations {

    // Method to write content to a text file
    public static void writeFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println(" File written successfully.");
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }
    }

    // Method to read content from a text file
    public static void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println(" File content:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }

    // Method to append content to an existing file
    public static void appendToFile(String filename, String contentToAppend) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("\n" + contentToAppend);
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println(" Error appending to file: " + e.getMessage());
        }
    }

    // Main method demonstrating file handling operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filename = "internship_file.txt";

        // 1. Write to file
        System.out.println(" Enter text to write to the file:");
        String initialContent = scanner.nextLine();
        writeFile(filename, initialContent);

        // 2. Read the file
        readFile(filename);

        // 3. Modify (Append) content to the file
        System.out.println("Enter text to append to the file:");
        String moreContent = scanner.nextLine();
        appendToFile(filename, moreContent);

        // 4. Read updated file
        System.out.println("\nReading file after appending:");
        readFile(filename);

        scanner.close();
    }
}
