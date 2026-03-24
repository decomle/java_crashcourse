package test.dsa.dynamicprogramming;

public class LongestCommonSubsequence {
    public static int findLongestSubSequenceBrute(String org, String sub) {
        Integer[][] memo = new Integer[org.length()][sub.length()];
        return dfsBrute(0, 0, org, sub, memo);
    }

    private static int dfsBrute(int row, int col, String s1, String s2, Integer[][] memo) {
        if(row == s1.length() || col == s2.length()) {
            return  0;
        }
        if(memo[row][col] != null) {
            return memo[row][col];
        }
        if(s1.charAt(row) == s2.charAt(col)) {
            return memo[row][col] = 1 + dfsBrute(row + 1, col + 1, s1, s2, memo);
        }
        int skip1 = dfsBrute(row + 1, col, s1, s2, memo);
        int skip2 = dfsBrute(row, col + 1, s1, s2, memo);
        return memo[row][col] = Math.max(skip1, skip2);
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "acj";

        int longestSub = findLongestSubSequenceBrute(s1, s2);
        System.out.println(longestSub);
    }
}
