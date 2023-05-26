import java.io.FileWriter;
import java.io.IOException;

public class XmlWriter {
    public static void writer() {
        String xmlData = generateXMLData(); // Generate the XML content

        String fileName = "C:\\Users\\Detelina\\IdeaProjects\\xml_k_r\\src\\file.xml"; // Specify the file name

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(xmlData);
            fileWriter.close();

            System.out.println("XML data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the XML data: " + e.getMessage());
        }
    }

    private static String generateXMLData() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlBuilder.append("<data>\n");
        xmlBuilder.append("    <user>\n");
        xmlBuilder.append("        <name>Jolene Doeful</name>\n");
        xmlBuilder.append("        <address>Bangladesh</address>\n");
        xmlBuilder.append("    </user>\n");
        xmlBuilder.append("</data>");

        return xmlBuilder.toString();
    }
}
