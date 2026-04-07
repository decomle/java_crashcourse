package test.dsa;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOneBrute(int[] digits) {
        int factor = 0, total = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            total += (int) (Math.pow(10, factor++) * digits[i]);
        }
        total = total + 1;

        int noOfDigits = digits.length;
        if(total % Math.pow(10, factor) == 0) {
            noOfDigits++;
        }
        int[] newDigits = new int[noOfDigits];
        while(total > 0) {
            noOfDigits--;
            newDigits[noOfDigits] = total%10;
            total = total/10;
        }

        return newDigits;
    }

    public static int[] plusOne(int[] digits) {
        int[] newDigits = digits.clone();

        for(int i = newDigits.length - 1; i >= 0; i--) {
            if(newDigits[i] < 9) {
                newDigits[i]++;
                return newDigits;
            }
            newDigits[i] = 0;
        }

        newDigits = new int[newDigits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }
}
