package test.dsa;

import java.util.*;
import java.util.stream.Stream;

public class GroupAnagram {
    public static List<List<String>> groupAnagramsBrute(String[] arr) {
        List<List<String>> result = new ArrayList<>();

        boolean[] isAdded = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++) {
            if(isAdded[i]) {
                continue;
            }
            List<String> groupAnas = new ArrayList<>();
            groupAnas.add(arr[i]);
            for(int j = i + 1; j < arr.length; j++) {
                if(isAdded[j]) {
                    continue;
                }
                if(isAnagram(arr[i], arr[j])) {
                    isAdded[j] = true;
                    groupAnas.add(arr[j]);
                }
            }

            result.add(groupAnas);
        }

        return result;
    }

    private static boolean isAnagram(String t1, String t2) {
        if(t1.length() != t2.length()) {
            return false;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < t1.length(); i++) {
            charMap.put(t1.charAt(i), charMap.getOrDefault(t1.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t1.length(); i++) {
            charMap.put(t2.charAt(i), charMap.getOrDefault(t2.charAt(i), 0) - 1);
        }

        return charMap.values().stream().allMatch(remain -> remain == 0);
    }

    public static List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: arr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        String[] arr = {"bat", "nat", "tan", "ate", "eat", "tea"};

        groupAnagrams(arr).stream().forEach(list -> {
            list.stream().forEach(str -> System.out.print(str + " "));
            System.out.println();
        });

    }
}
