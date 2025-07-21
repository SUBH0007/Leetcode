class Solution {
    public String makeFancyString(String s) {
        
         StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int len = sb.length();
            // Check if last two characters in sb are same as current
            if (len >= 2 && sb.charAt(len - 1) == s.charAt(i) && sb.charAt(len - 2) == s.charAt(i)) {
                continue;  // skip adding third repeated character
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
    }