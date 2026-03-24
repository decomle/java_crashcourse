package test.dsa;

public class ThirdMaximunNumber {
    public static int thirdMaxNum(int[] nums) {
        Integer first = nums[0], second = null, third = null;
        for(int num: nums) {
            if(num > first) {
                third = second;
                second = first;
                first = num;
            } else if(num != first && num > second) {
                third = second;
                second = num;
            } else if(num != second && num > third) {
                third = num;
            }
        }

        return third ==  null ? first : third;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,3,8,2,6,7,4};
        System.out.println(thirdMaxNum(nums));
    }
}
