package org.yourcompany.yourproject.algorithm;

import java.util.List;

public interface SimilarityAlgorithm {
    // interface will declare methods but does not define them
    double calculate(List<String> tokens1, List<String> tokens2);
    
}
