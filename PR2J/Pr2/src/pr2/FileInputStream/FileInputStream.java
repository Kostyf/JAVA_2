import java.io.*;
import java.nio.channels.*;

public class FileInputStream {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        try {
            java.io.FileInputStream in = new java.io.FileInputStream("input.txt");
            FileOutputStream out = new FileOutputStream("output.txt");
            FileChannel inChannel = in.getChannel();
            FileChannel outChannel = out.getChannel();
            inChannel.transferTo(0, inChannel.size(), outChannel);
            in.close();
            out.close();
            inChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken by FileChannel: " + (endTime - startTime) + " nanoseconds");
    }
}
