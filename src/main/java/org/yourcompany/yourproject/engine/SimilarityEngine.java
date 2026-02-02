package org.yourcompany.yourproject.engine;

import java.util.List;

import org.yourcompany.yourproject.algorithm.SimilarityAlgorithm;
import org.yourcompany.yourproject.util.TextProcessor;


public class SimilarityEngine {
    // pipelining (sequential) the text processing with algorithms
    public double compute(String text1, String text2, SimilarityAlgorithm algorithm){
        
        List<String> tokens1 = TextProcessor.process(text1);
        List<String> tokens2 = TextProcessor.process(text2);


        return algorithm.calculate(tokens1, tokens2);
    }
    
}
