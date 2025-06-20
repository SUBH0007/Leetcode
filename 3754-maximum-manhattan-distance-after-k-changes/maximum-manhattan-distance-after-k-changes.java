class Solution {
    private char[] s;
    private int k;

    public int maxDistance(String s, int k) {
        this.s = s.toCharArray();
        this.k = k;

        int a = calc('S', 'E');
        int b = calc('S', 'W');
        int c = calc('N', 'E');
        int d = calc('N', 'W');
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

    private int calc(char a, char b) {
        int ans = 0, max = 0, count = 0;

        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == a || c == b) {
                max++;
            } else if (count < k) {
                max++;
                count++;
            } else {
                max--;
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
}