package test.dsa;

public class RunningSum {
    public static long[] runningSum(int[] nums) {
        long[] result = new long[nums.length];
        result[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }

        return result;
    };

    public static void main(String[] args) {
        for(long sum : runningSum(new int[] {1, 2, 3, 4, 5})) {
            System.out.print(sum + " ");
        }
    }

}
