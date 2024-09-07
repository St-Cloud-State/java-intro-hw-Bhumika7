import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {

    // Reads data from input stream and stores in linked list
    public static void store(InputStream in, LinkedList<Person> list) {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) {
                list.add(new Person(parts[0].trim(), parts[1].trim(), parts[2].trim()));
            }
        }
        scanner.close();
    }

    // Writes data from linked list to output stream
    public static void display(OutputStream out, LinkedList<Person> list) {
        PrintStream printStream = new PrintStream(out);
        for (Person person : list) {
            printStream.println(person.toString());
        }
    }

    // Finds a person by ID in the linked list
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        LinkedList<Person> list = new LinkedList<>();

        // Example data for testing
        String data = "Bhumika,Basnet,1\nJohn,Doe,2\nJane,Smith,3";
        InputStream inputStream = new java.io.ByteArrayInputStream(data.getBytes());

        // Store and display data
        store(inputStream, list);
        System.out.println("Displaying all persons in the list:");
        display(System.out, list);

        // Find a person by ID
        String searchId = "2";
        int index = find(searchId, list);
        if (index != -1) {
            System.out.println("Person with ID " + searchId + " found at index " + index + ": " + list.get(index));
        } else {
            System.out.println("Person with ID " + searchId + " not found.");
        }
    }
}
