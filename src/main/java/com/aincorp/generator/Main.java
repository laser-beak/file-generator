package com.aincorp.generator;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        for (int j = 1; j <= 5; j++) {
        //    for (int j = 6; j <= 10; j++) {
          //      for (int j = 11; j <= 15; j++) {
            //        for (int j = 16; j <= 20; j++) {

            try (FileChannel channel = (FileChannel) Files.newByteChannel(Paths.get("C:\\test\\file" + j + ".txt"),
                    StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE)) {
                MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024 * 1024 * 1124);

                Random random = new Random();

                for (int i = 0; i < 1024; i++) {

                    StringBuilder stringBuilder = new StringBuilder();

                    while (stringBuilder.length() < 1024 * 1024) {
                        stringBuilder.append(random.nextInt() & Integer.MAX_VALUE);
                        stringBuilder.append(',');
                    }

                    buffer.put(stringBuilder.toString().getBytes());
                }
            } catch (IOException ex) {
                System.out.println("Input / Output error" + ex);
            }
        }
    }
}
