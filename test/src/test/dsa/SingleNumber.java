package test.dsa;

// letcode 136: Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//You must implement a solution with a linear runtime complexity and use only constant extra space
public class SingleNumber {
    public static int singleNumber(int ...nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // result = result XOR num
            System.out.println("result: " + result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(4,1,2,1,2));
    }
}
