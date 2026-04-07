package test.dsa.search;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while(s.charAt(i) == ' ') {
            i--;
        }
        int count = 0;
        while(i >= 0 && s.charAt(i) != ' ') {
            i--;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   Hello world  "));
        System.out.println(Math.pow(10, 0));
    }
}
