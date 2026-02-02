package org.yourcompany.yourproject.UI;

import java.util.Scanner;

import org.yourcompany.yourproject.algorithm.CosineSimilarity;
import org.yourcompany.yourproject.algorithm.JaccardSimilarity;
import org.yourcompany.yourproject.engine.SimilarityEngine;

public class ConsoleUI {
    
    public void start(){
        Scanner scanner = new Scanner(System.in);
        SimilarityEngine simEng = new SimilarityEngine();
        // double number = scanner.nextInt(); // picks up the next number from entry
        System.out.println("What is the path of the first text you would like to compare?");
        String string1 = scanner.nextLine();  // picks up entire line from most recent entry
        System.out.println("What is the path of the second text you would like to compare?");
        String string2 = scanner.nextLine();
        System.out.println("Simiarlity results:");
        System.out.println("Jaccard Similarity:" + simEng.compute(string1, string2, new JaccardSimilarity()));
        System.out.println("Cosine Similarity:" + simEng.compute(string1, string2, new CosineSimilarity()));

        


    }
    


}
