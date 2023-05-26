import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {
    private static final String FILE_PATH = "C:\\Users\\Detelina\\IdeaProjects\\xml_k_r\\src\\file.xml";



    public static void openFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("<people> <person id=”0”>\n" +
                    "<name>John Smith</name>\n" +
                    "<address>USA</address> </person>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFileAs(String newPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(newPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void showMenuOptions() {
        System.out.println("File Management System");
        System.out.println("-----------------------");
        System.out.println("0. Open");
        System.out.println("1. Save");
        System.out.println("2. Save As");
        System.out.println("3. Close");
        System.out.println("4. write File");
        System.out.println("5. Read File");
        System.out.println("6. Compare");
        System.out.println("7. Read File");
        System.out.println("8. Xml manipulator");
        System.out.println("9. Read xml ");
        System.out.println("10. Write in xml");
        System.out.println("11. Show All");
        System.out.print("Enter your choice: ");
    }

    public static void processUserInput(Scanner scanner) {
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
    }

    public static void closeFile() {

    }
}
