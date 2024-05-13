package com.example;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
 

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
        System.out.println("Usage: java -jar toy-language.jar <source-file-path>");
        return;
        }

        if (!args[0].endsWith(".tq")) {
        System.out.println("Only accept file with extension .tq");
        return;
        }

        // Path path = Paths.get("src/main/resources/tien.tq");
        Path path = FileSystems.getDefault().getPath(args[0]);
        if (!Files.exists(path)) {
            System.out.println("File not found");
            return;
        }
        TqLanguage tqLanguage = new TqLanguage();
        tqLanguage.execute(path);
    }
}