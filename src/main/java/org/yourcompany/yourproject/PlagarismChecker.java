package org.yourcompany.yourproject;

import java.io.IOException;

import org.yourcompany.yourproject.UI.ConsoleUI;

public class PlagarismChecker {

    public static void main(String[] args) throws IOException{
        ConsoleUI ui = new ConsoleUI();
        ui.start();
        //String string1 = "the dog went on a walk";
        // String string2 = "the cat went on two jogs";

        // TextLoader txtLoad = new TextLoader();
        // String string1 = TextLoader.load("C:\\Users\\xiaop\\java projects\\PlagarismChecker\\src\\main\\java\\org\\yourcompany\\yourproject\\util\\text1.txt");
        // String string2 = TextLoader.load("C:\\Users\\xiaop\\java projects\\PlagarismChecker\\src\\main\\java\\org\\yourcompany\\yourproject\\util\\text2.txt");
        // SimilarityEngine simEng = new SimilarityEngine();
        // System.out.println(simEng.compute(string1 ,string2, new JaccardSimilarity()));
        // System.out.println(simEng.compute(string1,string2, new CosineSimilarity()));
        
        // finish up console ui
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
            |       gui/
            |       └── PlagiarismFrame.java
            │
            ├── engine/
            │     └── SimilarityEngine.java
            │
            ├── algorithm/
            │     ├── SimilarityAlgorithm.java
            │     ├── JaccardSimilarity.java
            │     └── CosineSimilarity.java
                  └── TFIDFSimilarity.java
            │
            └── util/
                  ├── TextLoader.java
                  ├── TextPreprocessor.java
                  └── Tokenizer.java */

// input -> preprocessing -> algorithm -> score -> output

// UI    -> engine      -> algorithm    ->  math