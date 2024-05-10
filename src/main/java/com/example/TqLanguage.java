package com.example;

import java.nio.file.Files;
import java.nio.file.Path;

import lombok.SneakyThrows;

public class TqLanguage {
    @SneakyThrows
    public void execute(Path path) {
          String sourceCode = Files.readString(path);
           System.out.println(sourceCode);
    }
}
