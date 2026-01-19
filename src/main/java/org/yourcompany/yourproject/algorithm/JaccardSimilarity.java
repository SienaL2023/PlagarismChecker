package org.yourcompany.yourproject.algorithm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JaccardSimilarity implements SimilarityAlgorithm{
    
    @Override
    public double calculate(List<String> tokens1, List<String> tokens2){
        // A n B
        Set<String> set1 = new HashSet<>(tokens1);
        Set<String> set2 = new HashSet<>(tokens2);

        // Set.retainAll --> (retaining (keeping) the ones the 2 
        // share only, getting rid of the rest)
        // retains only the elements in the calling set AND in the specified collection

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // A U B
        // set.addAll --> adds all the elements of the specificed collection
        // into the current set
        // does not duplicate elements that are already there

        Set<String> union = new  HashSet<>(set1);
        union.addAll(set2);

        if(union.isEmpty()){
            return 0;
        }
        else{
            return (double) intersection.size()/union.size();
        }
    }

}


// jaccard similarity
// measure similarity between 2 data sets (0-1)
// A n B  (a and b)
// A U B (a or b)


// J(A,B) = (A n B)/(A U B)

// where A n B = number of common elements between sets
// (5,4,3,2,1) and (5,5,2,2,0)= 5, 2
// where a u b = total num of unique elements in both sets
// (5,4,3,2,1) OR (5,5,2,2,0) = 5,4,3,2,1,0
// 2/6 = 1/3 = J(A,B)