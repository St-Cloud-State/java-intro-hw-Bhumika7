import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain2 {

    // Reads data from InputStream and adds lines as strings to the linked list
    public static void store(InputStream in, LinkedList<String> list) {
        try (Scanner scanner = new Scanner(in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }

    // Writes list data as strings to OutputStream
    public static void display(OutputStream out, LinkedList<String> list) {
        try (PrintStream printStream = new PrintStream(out)) {
            if (list.isEmpty()) {
                printStream.println("No data to display.");
            } else {
                for (String line : list) {
                    printStream.println(line);
                }
            }
        }
    }

    // Finds a string by ID in the linked list (assumes ID is part of the string)
    public static int find(String sid, LinkedList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(sid)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Sample data as strings
        String sampleData = "Bhumika,Basnet,1";
        list.add(sampleData);

        // Display sample data
        System.out.println("Hello, World!");
        System.out.println("Sample Data: " + sampleData);

        // Test data in string format
        String data = "John,Doe,2\nJane,Smith,3\nInvalidData";
        InputStream inputStream = new java.io.ByteArrayInputStream(data.getBytes());

        // Store and display data
        store(inputStream, list);
        System.out.println("\nDisplaying all strings in the list:");
        display(System.out, list);

        // Find a string containing the specified ID
        String searchId = "2";
        int index = find(searchId, list);
        if (index != -1) {
            System.out.println("\nString containing ID " + searchId + " found at index " + index + ": " + list.get(index));
        } else {
            System.out.println("\nString containing ID " + searchId + " not found.");
        }
    }
}
