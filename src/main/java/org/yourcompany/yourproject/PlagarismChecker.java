package org.yourcompany.yourproject;

import java.util.List;

import org.yourcompany.yourproject.algorithm.CosineSimilarity;
import org.yourcompany.yourproject.algorithm.JaccardSimilarity;
import org.yourcompany.yourproject.util.TextProcessor;

public class PlagarismChecker {

    public static void main(String[] args) {
        List<String> a = List.of("Java", "class", "is", "today");
        List<String> b = List.of("Python", "lesson", "not", "tomorrow");

        List<String> list = TextProcessor.process("Java class isn't   today");
        System.out.println(list);
        
        System.out.println(new JaccardSimilarity().calculate(a,b));
        System.out.println(new CosineSimilarity().calculate(a,b));
    }
}


/* PlagiarismChecker/
└── src/
    └── com/
        └── plagiarism/
            ├── plagarismchecker.java
            │
            ├── ui/
            │     └── ConsoleUI.java
            │
            ├── engine/
            │     └── SimilarityEngine.java
            │
            ├── algorithm/
            │     ├── SimilarityAlgorithm.java
            │     ├── JaccardSimilarity.java
            │     └── CosineSimilarity.java
            │
            └── util/
                  ├── TextLoader.java
                  ├── TextPreprocessor.java
                  └── Tokenizer.java */

// input -> preprocessing -> algorithm -> score -> output

// UI    -> engine      -> algorithm    ->  math