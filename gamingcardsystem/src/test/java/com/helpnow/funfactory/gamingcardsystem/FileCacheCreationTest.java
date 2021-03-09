package com.helpnow.funfactory.gamingcardsystem;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class FileCacheCreationTest {
    public static void main(String[] args) {
        try (InputStream is = FileCacheCreationTest.class.getResourceAsStream("./userDetails.json")) {
            System.out.println("worked,...");
            if (is == null) {
                createFile();
                return;
            }
            try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String cache = in.lines().collect(Collectors.joining());
                System.out.println(cache);
            }
        } catch (IOException e) {
            createFile();
        }
    }

    private static void createFile() {
        System.out.println("creating the file...");
        try {
            File file = new File("./userDetails.json");
            FileOutputStream fos = new FileOutputStream(file);
            fos.flush();
            System.out.println("file exists : " + file.exists());
        } catch (IOException ioe) {
            // add logger ... find out why it happened.
        }
    }

}
