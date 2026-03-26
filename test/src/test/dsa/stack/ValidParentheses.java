package test.dsa.stack;

import java.util.Stack;

public class ValidParentheses {
    private static final char[] OPEN = {'{','[','('};
    private static final char[] CLOSE = {'}',']',')'};
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< str.length(); i++) {
            char currentChar = str.charAt(i);
            if(contain(OPEN, currentChar)) {
                stack.push(currentChar);
            } else if(contain(CLOSE, currentChar)) {
                if(stack.isEmpty()) {
                    return false;
                }
                char peek = stack.peek();
                if(currentChar == '}' && peek != '{') {
                    return false;
                } else if (currentChar == ']' && peek != '[') {
                    return false;
                } else if (currentChar == ')' && peek != '(') {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
    private static boolean contain(char[] chars, char val) {
        for(char c : chars) {
            if(c == val) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isValid("{{[()]}}")); // true
        System.out.println(isValid("{{[(]}}")); // false
        System.out.println(isValid("{[]()}")); // true
        System.out.println(isValid("[{}[]()]")); // true
    }
}
