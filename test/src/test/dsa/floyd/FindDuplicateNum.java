package test.dsa.floyd;

public class FindDuplicateNum {
    public static Integer findDuplicate(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        if (nums.length < 2) {
            throw new IllegalArgumentException(
                    "Array must contain at least two elements"
            );
        }

        int n = nums.length;

        for (int num : nums) {
            if (num < 1 || num > n) {
                throw new IllegalArgumentException(
                        "Array must contain values in range [1, n], found: " + num
                );
            }
        }

        int slow = 0, fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

            System.out.println(slow + " | " + fast);
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] valid = {1, 2, 3, 4, 2, 2};
        System.out.println(findDuplicate(valid));
    }
}
