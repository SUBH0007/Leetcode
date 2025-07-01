class Solution {
    public int possibleStringCount(String word) {
        int n = word.length(), ans = 0;
        for (int i = 0; i < n-1; i++){
            if (word.charAt(i) == word.charAt(i+1))
                ans++;
        }
        return ans+1;
    }
}