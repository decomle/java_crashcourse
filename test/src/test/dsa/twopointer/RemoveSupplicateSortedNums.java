package test.dsa.twopointer;

public class RemoveSupplicateSortedNums {
    public static int removeDupplicate(Integer[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }

        int i = 1, j = 1;
        while(j < nums.length) {
            if(nums[j] != nums[j -1]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        for(int k = i; k<nums.length; k++) {
            nums[k] = null;
        }
        return i;
    }
    public static void main(String[] args) {
        // Should be sorted
        Integer[] nums = {1,2,2,3,4,4,4,8,8,9,11,19};
        int k = removeDupplicate(nums);
        for(Integer num: nums) {
            System.out.print(num == null ? "null " : num + " ");
        }
        System.out.println();
        System.out.println(k);
    }
}
