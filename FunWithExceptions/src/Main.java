import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        // Checked exception (IO / DB)
        readFile("myFile.txt");

        // Unchecked exception (NullPointer etc.)
        String input = null;
        printLength(input);
    }

    /**
     *
     * @param fileName
     */
    public static void readFile(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            reader.read();
        }
        catch (IOException err) {
            System.out.println("Error loading file.");
        }
    }

    /**
     *
     * @param input
     */
    public static void printLength(String input) {

        if (input != null && !input.trim().isEmpty()) {
            System.out.println(input.length());
        }
    }
}