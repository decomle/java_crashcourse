package test.dsa;

import java.util.Arrays;

public class PalindromeNumber {
    public static boolean isPalindromeBrute(int num) {
        if(num < 0) {
            return false;
        }

        String numStr = String.valueOf(num);
        int left = 0, right = numStr.length() -1;
        while(left<right) {
            if(numStr.charAt(left)!=numStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Some math weirdo do this
    public static boolean isPalindromeOptimal(int num) {
        if(num < 0 || (num != 0 && num % 10 == 0)) {
            return false;
        }

        int reversedHalf = 0;
        while(num > reversedHalf) {
            reversedHalf = (reversedHalf * 10) + (num % 10);
            num /= 10;

            System.out.println(num + " | " + reversedHalf);
        }

        return num == reversedHalf || num == reversedHalf / 10;
    }

    // Humanly understandable - still optimal in bigO notation
    public static boolean isPalindrome(int num) {
        if(num < 0 || (num != 0 && num % 10 == 0)) {
            return false;
        }

        int[] digits = new int[10];
        int count = 0;
        while(num > 0) {
            digits[count++] = num%10;
            num = num/10;
        }

        int left = 0, right = count - 1;
        while(left < right) {
            if(digits[left] != digits[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
