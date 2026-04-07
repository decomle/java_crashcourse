package test.dsa;

//Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.
public class MajorityElement {
    public static int findMajorityElement(int ...nums) {
        int count = 0;
        int candidate = 0;

        for(int num: nums) {
            if(count == 0) {
                candidate = num;
            }
            count = num == candidate ? count + 1: count - 1;
        }
        int frequency = 0;
        for(int num: nums) {
            if(num == candidate) frequency++;
        }
        if(frequency > nums.length/2) {
            return candidate;
        } else {
            throw new IllegalArgumentException("No majority was given");
        }
    }

    public static void main(String[] args) {
        System.out.println(findMajorityElement(1,2,3));
    }
}
