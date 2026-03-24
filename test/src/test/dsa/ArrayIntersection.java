package test.dsa;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayIntersection {
    // BETTER
    public static int[] alternateSolution(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num: nums1) {
            set1.add(num);
        }
        Set<Integer> resultSet = new HashSet<>();
        for(int num: nums2) {
            if(set1.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result = new int[resultSet.size()];
        int index=0;
        for(int num: resultSet) {
            result[index++] = num;
        }


        return result;
    }
    public static int[] intersectionArray(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int num: nums1.length > nums2.length ? nums1 : nums2) {
            numMap.put(num, 1);
        }
        for(int num: nums1.length > nums2.length ? nums2 : nums1) {
            numMap.put(num, numMap.getOrDefault(num, 0) - 1);
        }
        return numMap.entrySet().stream().filter(entry -> entry.getValue() == 0).mapToInt(Map.Entry::getKey).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 5};
        int[] nums2 = {2, 3, 9};

        for(int num: alternateSolution(nums1, nums2)) {
            System.out.print(num + " ");
        }
    }
}
