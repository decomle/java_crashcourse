package test.dsa.search;

// Given a sorted array of distinct integers and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
public class SearchInsertPosition {
    public static int insertPosition(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1, mid = 0;
        while(left <= right) {
            mid = (int)((long)left + right)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        System.out.println(insertPosition(nums, -1));
    }
}
