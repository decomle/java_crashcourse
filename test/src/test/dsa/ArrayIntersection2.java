package test.dsa;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayIntersection2 {
    public static int[] intersectionArray(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num: nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] sortedGivenSolution(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if(nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 3, 5 };
        int[] nums2 = { 2, 2, 3 };

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for(int num: intersectionArray(nums1, nums2)) {
            System.out.print(num + " ");
        }
    }
}
