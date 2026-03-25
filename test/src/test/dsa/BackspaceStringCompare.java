package test.dsa;

import java.util.Stack;

public class BackspaceStringCompare {
    public static boolean backspaceStringCompareBrute(String t1, String t2) {
        Character[] t1chars = new Character[t1.length()];
        Character[] t2chars = new Character[t2.length()];

        int t1Index = 0;
        for(int i = 0; i < t1.length(); i++) {
            if(t1.charAt(i) != '#') {
                t1chars[t1Index] = t1.charAt(i);
                t1Index = t1Index + 1;
            } else {

                t1Index = Math.max(t1Index - 1, 0);
                t1chars[t1Index] = null;
            }
        }

        int t2Index = 0;
        for(int i = 0; i < t2.length(); i++) {
            if(t2.charAt(i) != '#') {
                t2chars[t2Index] = t2.charAt(i);
                t2Index = t2Index + 1;
            } else {

                t2Index = Math.max(t2Index - 1, 0);
                t2chars[t2Index] = null;
            }
        }

        if(t1Index != t2Index) {
            return false;
        } else {
            for(int i = 0; i < t1Index; i ++) {
                if(t1chars[i] != t2chars[i]) {
                    return false;
                }
            }

            return true;
        }
    }
    public static boolean backspaceString2Stack(String t1, String t2) {
        Stack<Character> stack1 = new Stack<>();
        for(int i=0; i < t1.length(); i++) {
            if(t1.charAt(i) != '#'){
                stack1.push(t1.charAt(i));
            } else {
                if(!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }

        Stack<Character> stack2 = new Stack<>();
        for(int i=0; i < t2.length(); i++) {
            if(t2.charAt(i) != '#'){
                stack2.push(t2.charAt(i));
            } else {
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }
        }

        return  stack1.equals(stack2);
    }
    public static boolean backspaceStringOptimized(String t1, String t2) {
        int i = t1.length() - 1;
        int j = t2.length() - 1;

        while (i >= 0 || j >= 0) {
            i = getNextValidIndex(t1, i);
            j = getNextValidIndex(t2, j);

            if (i < 0 && j < 0) {
                return true;
            };
            if (i < 0 || j < 0) {
                return false;
            };

            if (t1.charAt(i) != t2.charAt(j)) {
                return false;
            }

            i--;
            j--;
        }
        return true;
    }

    private static int getNextValidIndex(String str, int index) {
        int skip = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {
                skip++;
                index--;
            } else if (skip > 0) {
                skip--;
                index--;
            } else {
                break;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        System.out.println(backspaceStringOptimized("#ab#ce", "#ad#c")); // false
        System.out.println(backspaceStringOptimized("ab#c", "ad#c")); // true
        System.out.println(backspaceStringOptimized("ab##", "c#d#"));  // true
        System.out.println(backspaceStringOptimized("a#c", "b")); // false
    }
}
