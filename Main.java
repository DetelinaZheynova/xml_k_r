//Проект 3: XML Parser

import java.util.Scanner;

        public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FileOperations.processUserInput(scanner);

        System.out.println("Menu exited.");

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number == 0) {
            FileOperations.openFile();
            FileOperations.processUserInput(scanner);
        } else if (number == 1) {
            FileOperations.saveFile();
            FileOperations.processUserInput(scanner);
        } else if (number == 2) {
            FileOperations.saveFileAs("C:\\Users\\Detelina\\IdeaProjects\\xml_k_r\\src\\file.xml");
            FileOperations.processUserInput(scanner);
        } else if (number == 3) {
            FileOperations.closeFile();
            FileOperations.processUserInput(scanner);
        } else if (number == 4) {
            FileUse.writeFile();
            FileOperations.processUserInput(scanner);
        } else if (number == 5) {
            FileUse.readFile();
            FileOperations.processUserInput(scanner);
        } else if (number == 6) {
            XmlCompare.compare();
            FileOperations.processUserInput(scanner);
        } else if (number == 7) {
            XmlIdentifier.identify();
            FileOperations.processUserInput(scanner);
        } else if (number == 8) {
            XmlManipulator.manipulate();
            FileOperations.processUserInput(scanner);
        } else if (number == 9) {
            XmlReader.reader();
            FileOperations.processUserInput(scanner);
        } else if (number == 10) {
            XmlWriter.writer();
            FileOperations.processUserInput(scanner);
        } else if (number == 11) {
            FileOperations.showMenuOptions();
            FileOperations.processUserInput(scanner);
        }  else {
            scanner.close();
        }
    }
        }



//<people> <person id=”0”>
//<name>John Smith</name>
//<address>USA</address> </person>
// <person id=”2”>
////<name>Peter Pelov</name> <address>Bolivia</address> </person>
// <person id=”3”>
////<name>Ivo Kirov</name> <address>Panama</address> </person>
// <person id=”4”>
////<name>Iva Ivailova</name> <address>Portugal</address> </person>
// <person id=”5”>
////<name>George Pesov</name> <address>Argentina</address> </person>
// <person id=”6”>
////<name>Aia Vernice</name> <address>Venezuela</address> </person>
//<person id=”7”>
////<name>Alen Lake</name> <address>Latvia</address> </person>
// <person id=”8”>
////<name>Ivak Potter</name> <address>San Antonia</address> </person>
//<person id=”9”>
////<name>Mek Marcine</name> <address>France</address> </person>
// <person id=”10”>
////<name>Sart Kasov</name> <address>Bangladesh</address> </person>
// <person id=”11”>
////<name>John Delvers</name> <address>San Francisco</address> </person>
// <person id=”12”>
////<name>Peter Talen</name> <address>Serbia</address> </person>
// <person id=”13”>
////<name>Saf Paset</name> <address>Canada</address> </person>
// <person id=”14”>
////<name>Silvi Vaset</name> <address>Texas</address> </person>
//<person id=”15”>
////<name>Evie Albarn</name> <address>Spain</address> </person>
// <person id=”16”>
////<name>Claudia Petrolova</name> <address>Hungary</address> </person>
// <person id=”17”>
////<name>Mirajane Savol</name> <address>Switzerland</address> </person>
// <person id=”18”>
////<name>Sarah Starfel</name> <address>Greece</address> </person>
// <person id=”19”>
////<name>Vivian Shanes</name> <address>Italy</address> </person>
// <person id=”20”>
////<name>Violet Sinclair</name> <address>Latvia</address> </person>
//<person id=”21”>
////<name>Will Brom</name> <address>Estonia</address> </person>
// <person id=”22”>
////<name>Bernard Samsen</name> <address>Poland</address> </person>
// <person id=”23”>
////<name>Samvel Jayce</name> <address>Germany</address> </person>
// <person id=”24”>
////<name>Insil Devol</name> <address>Belgium</address> </person>
// <person id=”25”>
////<name>Shamel Heisenberg</name> <address>Denmark</address> </person>
// </people>

