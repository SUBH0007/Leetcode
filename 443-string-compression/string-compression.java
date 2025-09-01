class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int n = chars.length;
        int i = 0;
        while (i < n) {
            char current = chars[i];
            int count = 0;
            // Count consecutive occurrences of current character
            while (i < n && chars[i] == current) {
                i++;
                count++;
            }
            sb.append(current);
            if (count > 1) {
                sb.append(count);
            }
        }
        // Write back to chars[]
        for (int j = 0; j < sb.length(); j++) {
            chars[j] = sb.charAt(j);
        }
        return sb.length();
    }
}
