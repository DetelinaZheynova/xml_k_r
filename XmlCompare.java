import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XmlCompare {
    private static final String XML_FILE = "C:\\Users\\Detelina\\IdeaProjects\\xml_k_r\\src\\file.xml"; // Specify the path to your XML file

    public static void compare() {
        try {
            String xmlContent = readXMLFile(XML_FILE);

            String condition = "/root/element[@id='id1']/key = 'value1'";
            boolean match = evaluateCondition(xmlContent, condition);
            System.out.println("Condition match: " + match);
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

    private static boolean evaluateCondition(String xmlContent, String condition) {
        String[] parts = condition.split("=");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid condition: " + condition);
        }
        String leftOperand = parts[0].trim();
        String rightOperand = parts[1].trim();

        String leftValue = getElementValue(xmlContent, leftOperand);
        String rightValue = extractValueFromCondition(rightOperand);

        return leftValue.equals(rightValue);
    }

    private static String getElementValue(String xmlContent, String elementPath) {
        String[] pathParts = elementPath.split("/");
        String currentContent = xmlContent;
        for (String part : pathParts) {
            if (part.isEmpty()) {
                continue;
            }

            if (part.contains("[")) {
                String tag = part.substring(0, part.indexOf('['));
                int index = Integer.parseInt(part.substring(part.indexOf('[') + 1, part.indexOf(']')));
                currentContent = extractElementAtIndex(currentContent, tag, index);
            } else {
                currentContent = extractElementContent(currentContent, part);
            }
        }
        return currentContent.trim();
    }

    private static String extractElementContent(String xmlContent, String elementTag) {
        String startTag = "<" + elementTag + ">";
        String endTag = "</" + elementTag + ">";
        int startIndex = xmlContent.indexOf(startTag);
        int endIndex = xmlContent.indexOf(endTag);
        if (startIndex == -1 || endIndex == -1 || startIndex >= endIndex) {
            throw new IllegalArgumentException("Invalid element tag: " + elementTag);
        }
        return xmlContent.substring(startIndex + startTag.length(), endIndex);
    }

    private static String extractElementAtIndex(String xmlContent, String elementTag, int index) {
        String startTag = "<" + elementTag + ">";
        String endTag = "</" + elementTag + ">";
        int startIndex = xmlContent.indexOf(startTag);
        int count = 0;
        while (startIndex != -1) {
            int endIndex = xmlContent.indexOf(endTag, startIndex);
            if (count == index) {
                return xmlContent.substring(startIndex + startTag.length(), endIndex);
            }
            count++;
            startIndex = xmlContent.indexOf(startTag, endIndex);
        }
        throw new IndexOutOfBoundsException("Invalid index for element tag: " + elementTag);
    }

    private static String extractValueFromCondition(String conditionValue) {
        if (conditionValue.startsWith("'") && conditionValue.endsWith("'")) {
            return conditionValue.substring(1, conditionValue.length() - 1);
        } else {
            throw new IllegalArgumentException("Invalid condition value: " + conditionValue);
        }
    }

}
