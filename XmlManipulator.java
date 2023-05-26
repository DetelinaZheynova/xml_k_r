import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XmlManipulator {

        private static final String XML_FILE = "C:\\Users\\Detelina\\IdeaProjects\\xml_k_r\\src\\file.xml"; // Specify the path to your XML file

        public static void manipulate() {
            try {
                String xmlContent = readXMLFile(XML_FILE);

                // Delete an element by key
                xmlContent = deleteElementByKey(xmlContent, "key1");
                System.out.println("XML content after deleting an element:\n" + xmlContent);

                // Add a new child element
                xmlContent = addNewChild(xmlContent, "id2", "newKey", "newValue");
                System.out.println("XML content after adding a new child element:\n" + xmlContent);

                // Use XPath to extract element by id
                String xpath = "//element[id='id3']";
                String element = getElementByXPath(xmlContent, xpath);
                System.out.println("Element extracted using XPath:\n" + element);
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

        private static String deleteElementByKey(String xmlContent, String key) {
            String startTag = "<id>";
            String endTag = "</id>";
            int startIndex = xmlContent.indexOf(startTag);
            int endIndex;
            while (startIndex != -1) {
                endIndex = xmlContent.indexOf(endTag, startIndex);
                String currentKey = xmlContent.substring(startIndex + startTag.length(), endIndex);
                if (currentKey.equals(key)) {
                    int elementStartIndex = xmlContent.lastIndexOf("<element>", startIndex);
                    int elementEndIndex = xmlContent.indexOf("</element>", endIndex) + "</element>".length();
                    xmlContent = xmlContent.substring(0, elementStartIndex) + xmlContent.substring(elementEndIndex);
                    // Find next occurrence
                    startIndex = xmlContent.indexOf(startTag, elementStartIndex);
                } else {
                    startIndex = xmlContent.indexOf(startTag, endIndex);
                }
            }
            return xmlContent;
        }

        private static String addNewChild(String xmlContent, String id, String key, String value) {
            int startIndex = xmlContent.lastIndexOf("</element>") + "</element>".length();
            String newElement = "<element>\n" +
                    "    <id>" + id + "</id>\n" +
                    "    <key>" + key + "</key>\n" +
                    "    <value>" + value + "</value>\n" +
                    "</element>";
            xmlContent = xmlContent.substring(0, startIndex) + newElement + xmlContent.substring(startIndex);
            return xmlContent;
        }

        private static String getElementByXPath(String xmlContent, String xpath) {
            String element = "";
            String[] lines = xmlContent.split("\n");
            for (String line : lines) {
                if (line.matches(xpath)) {
                    element += line + "\n";
                }
            }
            return element;
        }
    }


