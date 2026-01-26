package org.yourcompany.yourproject.util;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {
    // convert string of text into a list of words (tokens!)

    public static List<String> tokenize(String text){
        // regex = regular expression
        // string split by space or multiple spaces
        // System.out.println(text);
        return Arrays.asList(text.split("\\s+")); 
    }
}
