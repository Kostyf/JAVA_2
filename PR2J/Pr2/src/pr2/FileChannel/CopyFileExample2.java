package pr2.FileChannel;

import java.io.*;

public class CopyFileExample2 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        try {
            FileInputStream in = new FileInputStream("input.txt");
            FileOutputStream out = new FileOutputStream("output.txt");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken by FileInputStream/FileOutputStream: " + (endTime - startTime) + " nanoseconds");
    }
}
