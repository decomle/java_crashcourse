package test.dsa;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    private static boolean isAnagram(String org, String ana) {
        if(org.length() != ana.length()) {
            return false;
        }

        Map<Character, Integer> charMap = new HashMap<>();

        char[] orgChars = org.toCharArray();
        for(char c: orgChars) {
            charMap.put(c, charMap.getOrDefault(c,0) + 1);
        }
        char[] anaChars = ana.toCharArray();
        for(char c: anaChars) {
            charMap.put(c, charMap.getOrDefault(c,0) - 1);
        }

        return charMap.values().stream().allMatch(value -> value == 0);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}

