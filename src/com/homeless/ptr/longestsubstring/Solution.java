package com.homeless.ptr.longestsubstring;
import java.util.*;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        char[] characters = s.toCharArray();
        Set<Character> set = new HashSet<>();
        StringBuilder buffer = new StringBuilder();
        for (char character : characters) {
            if (set.contains(character)) {
                if(i < buffer.length()) {
                    i = buffer.length();
                }
                buffer.delete(0, buffer.indexOf(String.valueOf(character)) + 1);
            }
            buffer.append(character);
            set.add(character);
        }
        if(i < buffer.length()) {
            i = buffer.length();
        }
        return i;
    }
}