import java.io.*;
import java.nio.file.*;

public class CopyFileExample4 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        try {
            Files.copy(new File("input.txt").toPath(), new File("output.txt").toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken by Files class: " + (endTime - startTime) + " nanoseconds");
    }
}
