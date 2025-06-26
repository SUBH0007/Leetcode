class Solution {
    public int numTilePossibilities(String tiles) {

        int[] count = new int[26];
        for (char tile : tiles.toCharArray())
            count[tile - 'A']++;

        return dfs(count);
    }

    private static int dfs(int[] count) {
        
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            count[i]--;
            ans += 1 + dfs(count);
            count[i]++;
        }

        return ans;
    }
}