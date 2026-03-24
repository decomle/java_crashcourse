package test.dsa.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSumCheck {
    public static boolean hasThreeSum(int[] arr, int target) {
        if (arr == null || arr.length < 3) {
            return false;
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }

    public static boolean hasThreeSumHashSet(int[] arr, int target) {
        if (arr == null || arr.length < 3) {
            return false;
        }

//        {5,6,1,1}, 13

        for (int i = 0; i < arr.length - 2; i++) {
            Set<Integer> seen = new HashSet<>();
            int currentTarget = target - arr[i];
            // i=0, currentTarget = 8

            for (int j = i + 1; j < arr.length; j++) {
                int complement = currentTarget - arr[j];
                // i=0 - j=1 - complement = 8-6=2 - seen={}
                // i=0 - j=2 - complement = 8-1=7 - seen={6}
                // i=0 - j=3 - complement = 8-1=7 - seen={6, 1}

                if (seen.contains(complement)) {
                    return true;
                }

                seen.add(arr[j]);
                // i=0 - j=1 - seen={6}
                // i=0 - j=2 - seen={6, 1}
                // i=0 - j=2 - seen={6, 1, 1}
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] array1 = {3,7,1,2,8,4,5};
        int s1 = 11;
        System.out.println(hasThreeSum(array1, s1)); // true

        int[] array2 = {3,7,1,2,8,4,5};
        int s2 = 99;
        System.out.println(hasThreeSum(array2, s2)); // false

        int[] array3 = {5,6,1,1};
        System.out.println(hasThreeSumHashSet(array3, 13));
    }
}
