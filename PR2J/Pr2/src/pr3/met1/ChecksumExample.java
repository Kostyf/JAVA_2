package pr3.met1;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ChecksumExample {
    public static void main(String[] args) {
        File file = new File("1.txt");
        try {
            long checksum = FileUtils.checksumCRC32(file);
            System.out.println("CRC32 Checksum: " + checksum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
