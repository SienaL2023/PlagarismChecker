package org.yourcompany.yourproject.UI;

import java.io.IOException;
import java.util.Scanner;

import org.yourcompany.yourproject.algorithm.CosineSimilarity;
import org.yourcompany.yourproject.algorithm.JaccardSimilarity;
import org.yourcompany.yourproject.algorithm.TFIDFSimilarity;
import org.yourcompany.yourproject.engine.SimilarityEngine;
import org.yourcompany.yourproject.util.TextLoader;

public class ConsoleUI {
    
    public void start() throws IOException{
        Scanner scanner = new Scanner(System.in);
        SimilarityEngine simEng = new SimilarityEngine();
        TextLoader txtLoad = new TextLoader();
        // double number = scanner.nextInt(); // picks up the next number from entry
        System.out.println("What is the path of the first text you would like to compare?");
        String string1 = TextLoader.load(scanner.nextLine());  // picks up entire line from most recent entry
        System.out.println("What is the path of the second text you would like to compare?");
        String string2 = TextLoader.load(scanner.nextLine());
        System.out.println("Simiarlity results:");
        System.out.println("Jaccard Similarity:" + simEng.compute(string1, string2, new JaccardSimilarity()));
        System.out.println("Cosine Similarity:" + simEng.compute(string1, string2, new CosineSimilarity()));
        System.out.println("TFIDF similarity:" + simEng.compute(string1,string2, new TFIDFSimilarity()));

        // String string1 = TextLoader.load("C:\\Users\\xiaop\\java projects\\PlagarismChecker\\src\\main\\java\\org\\yourcompany\\yourproject\\util\\text1.txt");
        // String string2 = TextLoader.load("C:\\Users\\xiaop\\java projects\\PlagarismChecker\\src\\main\\java\\org\\yourcompany\\yourproject\\util\\text2.txt");
        // SimilarityEngine simEng = new SimilarityEngine();
        // System.out.println(simEng.compute(string1 ,string2, new JaccardSimilarity()));
        // System.out.println(simEng.compute(string1,string2, new CosineSimilarity()));


    }
    


}
