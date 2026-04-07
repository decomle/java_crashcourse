package test.dsa.twopointer;

import java.util.Arrays;

public class RemoveDuplicatedInSortedArray {
    public static int removeDuplicated(int ...nums) {
        int i = 0;

        for(int k = 1; k < nums.length; k++) {
            if(nums[k] != nums[i]) {
                i++;
                nums[i] = nums[k];
            }
        }

        return i;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,4,5};
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicated(nums));
        System.out.println(Arrays.toString(nums));
    }
}
