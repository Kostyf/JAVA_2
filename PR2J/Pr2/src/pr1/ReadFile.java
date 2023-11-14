package pr1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get("example.txt"));
            String line = null;
            int count = 0;
            while ((line = reader.readLine()) != null && count < 3) {
                System.out.println(line);
                count++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
