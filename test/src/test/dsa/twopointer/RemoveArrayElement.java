package test.dsa.twopointer;

import java.util.Arrays;

public class RemoveArrayElement {

    public static int removeElement(int target, int ...nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != target) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(2, nums));
        System.out.println(Arrays.toString(nums));
    }
}
