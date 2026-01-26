package org.yourcompany.yourproject.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextLoader {
    // purpose: to load in files from file path
    public static String load(String path) throws IOException{
        return Files.readString(Path.of(path));
    }
}
