package test.dsa.search;

public class MinInRotatedSortedArray {
    public static int findMinBrute(int[] nums) {
        int min = nums[0], lastSearch = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
            if(lastSearch > min) {
                break;
            }
        }
        return min;
    }
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (int)(((long) left + right) / 2);
            System.out.println(left + " " + mid + " " + right);
            if(nums[mid] > nums[right] ) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {7,8,9,1,2,3,4,5};
        System.out.println(findMin(nums)); // 1
    }
}
