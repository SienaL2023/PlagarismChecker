package org.yourcompany.yourproject.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// what directions the vectors point too
public class CosineSimilarity implements SimilarityAlgorithm{
    @Override
    public double calculate (List<String> tokens1, List<String> tokens2){
        Map<String, Integer> freq1 = buildFrequency (tokens1); // make a map of each list
        Map<String, Integer> freq2 = buildFrequency(tokens2);

        double dot = 0;
        double mag1 = 0;
        double mag2 = 0;



        // GET DOT PRODUCT
        // keySet() allows u to loop through all and only the keys
        for(String key :freq1.keySet()){   
            dot += (freq1.get(key) * freq2.getOrDefault(key, 0));
        }

        // magnitude = sqrt(sum of each num in vector squared)

        // GET MAGNITUDES
        // get magnitude for freq1
        for(int value: freq1.values()){
            mag1 += (value*value);
        }
        // get magnitude for freq2
        for(int value: freq2.values()){
            mag2 += (value*value);
        }

        double answer = dot/(Math.sqrt(mag1 * mag2));
        return answer;

    }

    // calculate freqeuncy/occurence of each word and store in Map
    private Map<String, Integer> buildFrequency(List<String> tokens){
        Map<String, Integer> map = new HashMap<>();  // get and put!
        for(String token : tokens){  
            // getordefault gets u the value of the token, if the token isnt in it returns a 0
            map.put(token, map.getOrDefault(token, 0) + 1);
            }
                
        return map;
    }
}


// vector = mathematical + physical quantity (magnitude with direction)
// magnitude = how large in size/quantity

// dot product = operation on 2 vectors that produces a single number (scalar)
// to determine how much they point into the same direction

// cosine similaorty -> measures the similairty between two vectors by
// calculating the cosine of the angle between them

// C(A,B) = (A . B)/ (||A|| x ||B||)
// where (A . B) = dot product of vectors A and B
// ||A|| and ||B|| = magnitude (length) of the 2 vectors
// ||A|| x ||B|| = regular product of the 2 vector's magnitude

// results in range -1 and 1
// -1 = vectors point in opposite direction (nothing in similarity)
// 1 = vectors point in rxact same (identical)
// 0 = vectors are orthogonal (pointed in right angle) (indp/unrelated)

