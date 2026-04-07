package test.dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumProductOf2Elements {

    // T: O(nlogn)
    // S: O(n)
    // This solution is just fancy
    public static long maximumProduct(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num: nums) {
            maxHeap.offer(num);
        }

        return ((long)maxHeap.poll() - 1)*(maxHeap.poll() - 1);
    }

    // T: O(n)
    // S: O(1)
    public static long maximumProductBrute(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }

        int biggest = Math.max(nums[0], nums[1]), secondBiggest = Math.min(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] > biggest) {
                secondBiggest = biggest;
                biggest = nums[i];
            } else if(nums[i] > secondBiggest){
                secondBiggest = nums[i];
            }
        }

        return ((long)biggest - 1)*(secondBiggest -1);
    }


    public static void main(String[] args) {
        System.out.println(maximumProductBrute(new int[]{3, 4, 5, 2})); // 12

        System.out.println(maximumProductBrute(new int[]{1, 5, 4, 5})); // 16

        System.out.println(maximumProductBrute(new int[]{3, 7})); // 12
    }
}
