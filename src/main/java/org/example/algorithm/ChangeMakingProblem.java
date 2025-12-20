package org.example.algorithm;

import java.util.Arrays;

public class ChangeMakingProblem {

    public int changeMakingProblem(int[] coins, int sum) {
        int count = 0;
        coins = Arrays.stream(coins).sorted().toArray();
        int len = coins.length;
        for (int i = len - 1; i >=  0; i--) {
            while (sum >= coins[i]) {
                sum -= coins[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 20, 50};
        ChangeMakingProblem changeMakingProblem = new ChangeMakingProblem();
        System.out.println(changeMakingProblem.changeMakingProblem(coins, 60));
    }


}
