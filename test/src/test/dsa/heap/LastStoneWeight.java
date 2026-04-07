package test.dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class LastStoneWeight {
    public static int lastStoneWeightBrute(int[] weights) {
        int timeToRun = weights.length - 1;
        int remain = 0;
        while(timeToRun>=0) {
            int[] stones = heaviest2Stones(weights);
            if (stones[0] == -1) return 0;
            if (stones[1] == -1) return weights[stones[0]];

            remain = weights[stones[0]] - weights[stones[1]];
            weights[stones[0]] = remain;
            weights[stones[1]] = 0;

            timeToRun--;
        }
        return remain;
    }

    private static int[] heaviest2Stones(int[] weights) {
        int idx1 = -1, idx2 = -1, heaviest = 0, secondHeaviest = 0;
        for(int i = 0; i < weights.length; i++) {
            if(weights[i] > heaviest) {
                idx2 = idx1;
                secondHeaviest = heaviest;

                idx1 = i;
                heaviest = weights[i];
            } else if(weights[i] > secondHeaviest) {
                idx2 = i;
                secondHeaviest = weights[i];
            }
        }
        return new int[]{idx1, idx2};
    }

    public static int lastStoneWeight(int[] weights) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: weights) {
            maxHeap.offer(num);
        }

        while(maxHeap.size() > 1) {
            int heaviest = maxHeap.poll();
            int secondHeaviest = maxHeap.poll();

            if(heaviest != secondHeaviest) {
                maxHeap.offer(heaviest - secondHeaviest);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
    public static void main(String[] args) {
        int[] weights = {2, 7, 4, 1, 8, 1};

        IntStream.of(lastStoneWeight(weights)).forEach(num -> System.out.println(num));
    }
}
