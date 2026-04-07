package test.dsa;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Stream;

// Given: score are unique
public class RelativeRanks {
    // Time: O(n*n), Space: O(1)
    public static String[] relativeRanksBrute(int[] scores) {
        String[] result = new String[scores.length];
        for (int i=0; i<scores.length; i++) {
            int count = 0;
            for (int j=0; j<scores.length; j++) {
                if(scores[j] > scores[i]) {
                    count++;
                }
            }
            if(count == 0) {
                result[i] = "gold";
            } else if(count == 1) {
                result[i] = "silver";
            } else if(count == 2) {
                result[i] = "bronze";
            } else {
                result[i] = String.valueOf(count + 1);
            }
        }

        return result;
    }

    // Time: O(nLog(n)), Space: O(n)
    public static String[] relativeRanks(int[] scores) {
        String[] result = new String[scores.length];
        PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i< scores.length; i++) {
            maxHeap.offer(new Integer[] {scores[i], i});
        }
        int rank = 1;
        while(!maxHeap.isEmpty()) {
            Integer[] scoreAndIndex = maxHeap.poll();
            if(rank==1) {
                result[scoreAndIndex[1]] = "gold";
            } else if(rank==2) {
                result[scoreAndIndex[1]] = "silver";
            } else if(rank==3) {
                result[scoreAndIndex[1]] = "bronze";
            } else {
                result[scoreAndIndex[1]] = String.valueOf(rank);
            }

            rank++;
        }

        return result;
    }

    public static void main() {

        Stream.of(relativeRanks(new int[] {5, 4, 3, 2, 1})).forEach(position -> System.out.print(position + " ")); // gold silver bronze 4 5
        System.out.println();
        Stream.of(relativeRanks(new int[] {10, 3, 8, 9, 4})).forEach(position -> System.out.print(position + " ")); // gold 5 bronze silver 4
    }
}
