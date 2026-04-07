package test.dsa;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for(int i = 1; i < nums.length; i++) {
            int completion = target - nums[i];
            if(map.containsKey(completion)) {
                return new int[]{map.get(completion), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("Not found");
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }
}
