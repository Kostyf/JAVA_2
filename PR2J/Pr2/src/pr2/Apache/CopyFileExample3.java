package pr2.Apache;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CopyFileExample3 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        try {
            FileUtils.copyFile(new File("input.txt"), new File("output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken by Apache Commons IO: " + (endTime - startTime) + " nanoseconds");
    }
}
