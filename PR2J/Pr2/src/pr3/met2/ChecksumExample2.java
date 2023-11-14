package pr3.met2;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ChecksumExample2 {
    public static void main(String[] args) {
        File file = new File("1.txt");
        byte[] bytes = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            bis.read(bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sum = 0;
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        while (buffer.remaining() >= 2) {
            sum += buffer.getShort() & 0xFFFF;
        }
        while (sum >> 16 != 0) {
            sum = (sum & 0xFFFF) + (sum >> 16);
        }
        int checksum = ~sum & 0xFFFF;

        System.out.println("Checksum: " + checksum);
    }
}

//Этот код считывает файл в массив байтов с помощью FileInputStream и BufferedInputStream, а затем вычисляет контрольную сумму массива байтов с помощью двоичных операций. Массив байтов делится на сегменты по два байта каждый, и байты объединяются в 16-битное значение с помощью поразрядных операций. Затем значения суммируются, и контрольная сумма вычисляется путем дополнения суммы до единицы.
