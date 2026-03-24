package test.dsa.twopointer;

import java.util.Stack;

public class ReverseCharArray {
    public static void reverseString(char[] arr) {
        char temp;
        for(int i = 0, j = arr.length - 1; i < j; i++, j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void reverseStringAlternate(char[] arr) {
        Stack<Character> chars = new Stack<>();
        for(char c: arr) {
            chars.push(c);
        }

        for(int i = 0; i<arr.length; i++) {
            arr[i] = chars.pop();
        }
    }

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        for(char c : chars) {
            System.out.print(c);
        }
    }
}
