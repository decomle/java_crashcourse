package test.dsa.sliding;

public class LengthOfLongestSubArray {
    public static int longestSameValueSubarray(int[] array) {
        if(array==null || array.length == 0) {
            return 0;
        }
        int result = 1;

        int left = 0, right = 1;
        while(right < array.length) {
            System.out.println("Left: " + left + "| Right: " + right);
            System.out.println("Value Left: " + left + "| Value Right: " + right);
            if(array[left] == array[right]) {
                right++;
            } else {
                result = Math.max(right - left , result);
                left = right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {7, 3, 3, 3, 2, 2, 2, 2, 4};

        System.out.println("Longest same value subarray size: " + longestSameValueSubarray(array));
    }
}
