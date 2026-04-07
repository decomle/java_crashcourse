package test.dsa;

public class Sqrt {
    public static int doSqrtBrute(int num) {
        if(num < 2) return num;
        if(num < 4) return 1;

        for(int i = 0; i <= num/2 + 1; i++) {
            int pow = i * i;
            if(pow == num) {
                return i;
            } else if(pow > num) {
                return i - 1;
            }
        }
        return 0;
    }

    public static int doSqrt(int num) {
        if(num < 2) return num;

        int left = 1, right = num/2;
        while(left <= right) {
            int mid = left + (right - left)/2;

            if(mid == num/mid) {
                return mid;
            }
            if(mid < num/mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left + " | " + right);

        return right;
    }

    public static void main(String[] args) {
        System.out.println(doSqrt(4));
        System.out.println(doSqrt(5));
        System.out.println(doSqrt(6));
        System.out.println(doSqrt(7));
        System.out.println(doSqrt(8));
        System.out.println(doSqrt(9));
    }
}
