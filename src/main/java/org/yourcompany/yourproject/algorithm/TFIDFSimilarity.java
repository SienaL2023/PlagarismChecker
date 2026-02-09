package org.yourcompany.yourproject.algorithm;

import static java.lang.Math.log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TFIDFSimilarity implemnts SimilarityAlgorithm{
    @Override
    public double calculate(List<String> tokens1, List<String> tokens2){
        Map<String, Double> tfidf1 = computeTFIDF(tokens1,tokens2);
        Map<String, Double> tfidf2 = compteTFIDF(tokens1,tokens2);
        return cosine(tfidf1, tfidf2);
    }

    private Map<String, Double> TFCalculator(List<String> tokens1){
        // TF
        Map<String, Double> tfResults = new HashMap<>();
        // double wordFreq = 0;
        for(String word: tokens1.keySet()){
            //wordFreq += 1;
            tfResults.put(word, (tfResults.getOrDefault(word, 0.0) + 1)/2);
        }
        return tfResults;
    }

    private Map<String, Double> IDFCalculator(List<String> tokens1, List<String> tokens2){
        Map<String, Double> idfResults = new HashMap<>();

        int wordPresent = 0;
        for(String word: tokens1.keySet()){
            idfResults.put(word, Math.log(1.0/2.0));
                for(String word1: tokens2.keySet()){
                    if(idfResults.getOrDefault(word, 0.0) == 0.0)
                        idfResults.put(word1, Math.log(1.0/2.0));
                    else{
                        idfResults.put(word1, Math.log(2.0/2.0));
                    }

                }
        }
        return idfResults;
    }

    private Map<String, Double> computerTFIDF(List<String> tokens1, List<String> tokens2){
        Map<String, Double> tf = TFCalculator(tokens1);
        Map<String, Double> idf = IDFCalculator(tokens1, tokens2);
        Map<String, Double> TFIDFResults = new HashMap<>();
        for(String word, tf.keySet()){
            TFIDFResults.put(word, tf.get(word) * idf.get(word));
        }
        return TFIDFResults;


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
