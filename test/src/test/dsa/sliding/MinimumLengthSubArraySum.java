package test.dsa.sliding;

public class MinimumLengthSubArraySum {
    public static int shortestLengthSubarraySum(int[] array, int target) {
        int result = -1;

        int left = 0, total = 0;
        for(int right = 0; right < array.length; right++) {
            total += array[right];
            while(total >= target) {
                result = result == -1 ? (right - left + 1) : Math.min(result, (right - left + 1));
                total -= array[left];
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 2, 4, 3, 0};
        int result = shortestLengthSubarraySum(array,7);
        System.out.println("Shorest subarray length: " + result);
    }
}
