
import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;

public class XmlReader {
    public static void reader() {
        try {
            String fileName = "C:\\Users\\Detelina\\IdeaProjects\\xml_k_r\\src\\file.xml"; // Specify the path to your XML file
            String xmlContent = readXMLFile(fileName);

            // Extract information from XML
            String name = extractTagContent(xmlContent, "name");
            String address = extractTagContent(xmlContent, "address");

            // Print the information
            System.out.println("User: " + name);
            System.out.println("Address: " + address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readXMLFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder xmlContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            xmlContent.append(line);
        }
        reader.close();
        return xmlContent.toString();
    }

    private static String extractTagContent(String xmlContent, String tagName) {
        String startTag = "<" + tagName + ">";
        String endTag = "</" + tagName + ">";
        int startIndex = xmlContent.indexOf(startTag) + startTag.length();
        int endIndex = xmlContent.indexOf(endTag);
        return xmlContent.substring(startIndex, endIndex);
    }
}
