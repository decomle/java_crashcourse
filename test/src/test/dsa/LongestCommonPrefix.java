package test.dsa;

public class LongestCommonPrefix {
    // Time: O(S) - S is sum of all chars
    // Space: O(k) - k is length of first letter
    public static String findLongestPrefixBrute(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }
        String comparer = strs[0];
        for(int i = 1; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            int count = 0;
            for(int j = 0; j < Math.min(chars.length, comparer.length()); j++) {
                if(comparer.charAt(j) == chars[j]) {
                    count++;
                } else {
                    break;
                }
            }
            comparer = comparer.substring(0, count);
            if(comparer.isEmpty()) {
                return comparer;
            }
        }

        return comparer;
    }


    // Technical speaking, complexity is the same with brute way, but it's almost better in every way
    public static String findLongestPrefix(String[] strs) {
        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(findLongestPrefix(new String[] {"flower", "flow", "fly"}));
    }
}
