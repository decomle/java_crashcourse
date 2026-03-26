package test.dsa.search;

public class PerfectSquare {
    public static boolean isPerfectSquareBrute(int num) {
        int index = 0;
        while(index*index <= num) {
            if(index*index == num) {
                return true;
            }
            index++;
        }

        return false;
    }
    public static boolean isPerfectSquare(int num) {
        if(num < 2) {
            return true;
        }
        long left = 0, right = num/2;
        while(left<right) {
            long mid = (left + right)/2;
            long guess = mid*mid;

            if(guess == num) {
                return true;
            } else if(guess > num){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16)); // Return true
        System.out.println(isPerfectSquare(9)); // Return true
        System.out.println(isPerfectSquare(14)); // Return false
        System.out.println(isPerfectSquare(81)); // Return true
    }
}
