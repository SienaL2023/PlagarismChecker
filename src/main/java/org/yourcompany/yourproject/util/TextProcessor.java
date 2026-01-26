package org.yourcompany.yourproject.util;

import java.util.List;

public class TextProcessor {
    // preprocess all the texts/strings before getting tokensized

    public static List<String> process(String text){
        text = text.toLowerCase();

        // remove all chars except letters a-z and whitespace chars from string
        // ^ = not, so not a-z, replace with empty string
        text = text.replaceAll("[^a-z\\s]","");

        return Tokenizer.tokenize(text);
    }
}
