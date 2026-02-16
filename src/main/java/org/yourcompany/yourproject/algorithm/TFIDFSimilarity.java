package org.yourcompany.yourproject.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TFIDFSimilarity implements SimilarityAlgorithm{
    @Override
    public double calculate(List<String> tokens1, List<String> tokens2){
        Map<String, Double> tfidf1 = computeTFIDF(tokens1,tokens2);
        Map<String, Double> tfidf2 = computeTFIDF(tokens2,tokens1);
        // do tfidif on both documents then run through cosine

        // very similar to cosine but puts weights on certain words based on frequencies so more accurate
        return cosine(tfidf1, tfidf2);
    }

    private Map<String, Double> TFCalculator(List<String> tokens1){
        // TF
        Map<String, Double> tfResults = new HashMap<>();
        // double wordFreq = 0;
        for(String word: tokens1){
            //wordFreq += 1;
            // runs through token1 to find freqeuncy
            tfResults.put(word, (tfResults.getOrDefault(word, 0.0) + 1));
        }
        for(String word: tfResults.keySet()){  // divides by d (# of terms in docu)
            tfResults.put(word, tfResults.get(word)/tokens1.size());
        }
        return tfResults;
    }

    private Map<String, Double> IDFCalculator(List<String> tokens1, List<String> tokens2){
        Map<String, Double> idfResults = new HashMap<>();

        // int wordPresent = 0;
        for(String word: tokens1){
            idfResults.put(word, idfResults.getOrDefault(word, Math.log(2.0/1.0)));
                
        }
        for(String word1: tokens2){
            if(idfResults.getOrDefault(word1, 0.0) == 0.0)
                // if word isnt present already in map, add it and make it log2/1
                idfResults.put(word1, Math.log(2.0/1.0));
            else{
                // if word is already present in map, make value log 2/2
                idfResults.put(word1, Math.log(2.0/2.0));
            }
        }
        return idfResults;
    }

    private Map<String, Double> computeTFIDF(List<String> tokens1, List<String> tokens2){
        Map<String, Double> tf = TFCalculator(tokens1);
        Map<String, Double> idf = IDFCalculator(tokens1, tokens2);
        Map<String, Double> TFIDFResults = new HashMap<>();
        for(String word: tf.keySet()){
            TFIDFResults.put(word, tf.get(word) * idf.get(word));
        }

        // System.out.println("THIS IS TF " +tf);
        // System.out.println("THIS IS IDF " +idf);
        // System.out.println("THIS IS TFIDF " + TFIDFResults);
        return TFIDFResults;


    }

    private double cosine(Map<String, Double> tfidf1, Map<String, Double> tfidf2){
        
        // similar code from cosine file
        double dot = 0;
        double mag1 = 0;
        double mag2 = 0;



        // GET DOT PRODUCT
        // keySet() allows u to loop through all and only the keys
        for(String key :tfidf1.keySet()){   
            dot += (tfidf1.get(key) * tfidf2.getOrDefault(key, 0.0));
        }

        // magnitude = sqrt(sum of each num in vector squared)

        // GET MAGNITUDES
        // get magnitude for freq1
        for(double value: tfidf1.values()){
            mag1 += (value*value);
        }
        // get magnitude for freq2
        for(double value: tfidf2.values()){
            mag2 += (value*value);
        }

        double answer = dot/(Math.sqrt(mag1 * mag2));
        return answer;
    }
}



// TF - term freqeuncy
// measure how often a word appears in a document
// if higher frequency, suggests that it has a greater importance
// TF(t,d) = t/d
// where t = number of times term t appears in document d
// where d = number of terms in document d

// IDF - inverse document frequency
// reduces the weight of common words across multiple documents while
// increasing weight of rare words
// If a term appears in fewer documents, it is more likely to be important
// IDF(t, D) = log(D/t)
// where t = number of documents containing term t
// where D = number of documents 


// TFIDF (t,d,D) 
// used to evaluate how important a word is to a document in relation
// to a large collection of documents 
// = TF(t,d) * IDF(t,D)  -> product of TF and IDF
