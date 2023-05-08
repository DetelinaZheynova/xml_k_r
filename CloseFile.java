
import java.io.*;
import java.util.*;

class CloseFile {
    public static void main(String[] args)
    {

        try {
            String str = "GeeksForGeeks";

            // Create a Reader instance
            Reader reader
                    = new StringReader(str);

            // Close the stream using close()
            reader.close();
            System.out.println("Stream Closed.");

            // Check if the Reader is
            // ready to be read using ready()
            System.out.println("Is Reader ready "
                    + "to be read"
                    + reader.ready());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}