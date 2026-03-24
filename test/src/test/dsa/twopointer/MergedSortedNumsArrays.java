package test.dsa.twopointer;

public class MergedSortedNumsArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while(j >= 0) {
            if(i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void mergeAlternate(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        for(int i = 0, j = 0, k = 0; i + j < m + n; k++) {
            if(i == m) {
                nums[k] = nums2[j++];
            } else if(j == n) {
                nums[k] = nums1[i++];
            } else if(nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
        }

        for(int e=0; e < nums.length; e ++) {
            nums1[e] = nums[e];
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0, 0}, nums2 = {2, 5, 6, 9};
        int m = 3, n = 4;

        merge(nums1, m, nums2, n);

        for(int num: nums1) {
            System.out.print(num + " ");
        }

    }
}
