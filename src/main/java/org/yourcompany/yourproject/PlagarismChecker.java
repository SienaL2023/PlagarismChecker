package org.yourcompany.yourproject;

public class PlagarismChecker {

    public static void main(String[] args) {
        System.out.println("Hello World!");
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