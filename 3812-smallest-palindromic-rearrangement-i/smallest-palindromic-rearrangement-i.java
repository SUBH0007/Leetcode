import java.util.Arrays;

public class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        StringBuilder firstHalf = new StringBuilder();
        char middleChar = 0;
        
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            int count = freq[i];
            if (count > 0) {
                if (count % 2 == 1) {
                    if (middleChar == 0) {
                        middleChar = c;
                    } else {
                        // Since input is a palindrome, there can be at most one odd count
                        // So this case shouldn't happen for valid input
                    }
                }
                int num = count / 2;
                for (int j = 0; j < num; j++) {
                    firstHalf.append(c);
                }
            }
        }
        
        String firstHalfStr = firstHalf.toString();
        String secondHalfStr = firstHalf.reverse().toString();
        firstHalf.reverse(); // revert back to original
        
        String result;
        if (middleChar != 0) {
            result = firstHalfStr + middleChar + secondHalfStr;
        } else {
            result = firstHalfStr + secondHalfStr;
        }
        
        return result;
    }
}