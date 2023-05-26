import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUse {
    private static final String FILE_PATH = "C:\\Users\\Detelina\\IdeaProjects\\xml_k_r\\src\\file.xml";

    public static void main(String[] args) {
        writeFile();
        readFile();
    }

    public static void writeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("<person id=”1”>\n" +
                    "<name>Ivan Petrov</name> <address>Bulgaria</address> </person>");
            writer.newLine();
            writer.write("<person id=”2”>\n" +
                    "<name>Peter Pelov</name> <address>Bolivia</address> </person>");
            writer.newLine();
            writer.write("<person id=”3”>\n" +
                    "////<name>Ivo Kirov</name> <address>Panama</address> </person>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}