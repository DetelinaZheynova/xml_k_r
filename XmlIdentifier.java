import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XmlIdentifier {
    private static final String XML_FILE = "C:\\Users\\Detelina\\IdeaProjects\\xml_k_r\\src\\file.xml"; // Specify the path to your XML file
    private static int uniqueIdCounter = 1;
    private static Map<String, Integer> idCounterMap = new HashMap<>();

    public static void identify() {
        try {
            String xmlContent = readXMLFile(XML_FILE);

            String modifiedXML = assignUniqueIdentifiers(xmlContent);
            System.out.println("Modified XML with unique identifiers:\n" + modifiedXML);
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

    private static String assignUniqueIdentifiers(String xmlContent) {
        StringBuilder modifiedContent = new StringBuilder();
        String[] elements = xmlContent.split("<element>");

        for (String element : elements) {
            if (!element.trim().isEmpty()) {
                String modifiedElement = assignUniqueIdentifierToElement(element);
                modifiedContent.append("<element>").append(modifiedElement).append("</element>");
            }
        }

        return modifiedContent.toString();
    }

    private static String assignUniqueIdentifierToElement(String element) {
        String idTag = "<id>";
        String endIdTag = "</id>";
        int startIndex = element.indexOf(idTag);
        int endIndex = element.indexOf(endIdTag);
        if (startIndex != -1 && endIndex != -1) {
            String idValue = element.substring(startIndex + idTag.length(), endIndex).trim();

            if (isUniqueId(idValue)) {
                return element;
            } else {
                int counter = idCounterMap.getOrDefault(idValue, 1);
                idCounterMap.put(idValue, counter + 1);
                return element.replace(idValue, idValue + "_" + counter);
            }
        } else {
            return addUniqueIdentifierToElement(element);
        }
    }

    private static boolean isUniqueId(String idValue) {
        return !idCounterMap.containsKey(idValue);
    }

    private static String addUniqueIdentifierToElement(String element) {
        return element.replace("</element>", "<id>" + generateUniqueId() + "</id></element>");
    }

    private static String generateUniqueId() {
        return "generated_" + uniqueIdCounter++;
    }
}
