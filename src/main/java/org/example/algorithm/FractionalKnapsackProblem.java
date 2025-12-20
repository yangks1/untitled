package org.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FractionalKnapsackProblem {

    public int fractionalKnapsackProblem(int[] weights, double[] profits, int sum) {
        int max = 0;
        List<Double> avg = new ArrayList<>();
        int len = weights.length;
        for (int i = 0; i < len - 1; i++) {
            avg.add(profits[i]/weights[i]);
        }
        while(sum > 0){
        }


        return max;
    }

}
