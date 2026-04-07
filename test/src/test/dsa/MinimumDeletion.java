package test.dsa;

public class MinimumDeletion {
    public static int solutionBrute(String s) {
        char[] chars = s.toCharArray();

        int deletion = chars.length;
        for(int i = 0; i < chars.length; i++) {
            int count = chars.length;
            for(int cur = 0; cur < i; cur++) {
                if(chars[cur] == 'A') {
                    count--;
                }
            }
            for(int cur = i; cur < chars.length; cur++) {
                if(chars[cur] == 'B') {
                    count--;
                }
            }

            deletion = Math.min(count, deletion);
        }

        return deletion;
    }

    public static int solution(String s) {
        char[] chars = s.toCharArray();

        int deletionOfA = 0;
        for (int i = 0; i < chars.length; i++) {
            if (s.charAt(i) == 'A') {
                deletionOfA++;
            }
        }

        int bToTheLeft = 0;
        int minDeletions = deletionOfA;

        for (char aChar : chars) {
            if (aChar == 'A') {
                deletionOfA--;
            } else {
                bToTheLeft++;
            }

            minDeletions = Math.min(minDeletions, deletionOfA + bToTheLeft);
        }

        return minDeletions;
    }

    public static void main(String[] args) {
        System.out.println(solution("BAAABAB")); // 2
        System.out.println(solution("BBABAA")); // 3
        System.out.println(solution("AABBB"));  // 0
    }
}
