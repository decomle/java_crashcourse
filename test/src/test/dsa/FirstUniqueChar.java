package test.dsa;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static int findFirstUniqueCharBrute(String str) {
        int result = - 1;
        for(int i=0; i<str.length(); i++) {
            char currentChar = str.charAt(i);
            boolean found = false;
            for(int j = 0; j < str.length(); j++) {
                if(j==i) {
                    continue;
                }
                if(currentChar == str.charAt(j)) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static int findUniqueCharWithHashMap(String str) {
        int result = - 1;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            charMap.put(str.charAt(i), charMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        for(int i=0; i<str.length(); i++) {
            if(charMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findUniqueCharWithHashMap("leetcode"));
        System.out.println(findUniqueCharWithHashMap("loveleetcode"));
        System.out.println(findUniqueCharWithHashMap("aabb"));
        System.out.println(findUniqueCharWithHashMap("helloworld"));
    }
}
