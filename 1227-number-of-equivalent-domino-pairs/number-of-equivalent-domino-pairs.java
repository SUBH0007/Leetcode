class Solution {
   private static final int MAX_VALUE_1_INDEX = 10;
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] counter = new int[MAX_VALUE_1_INDEX][MAX_VALUE_1_INDEX];
        int res = 0;

        for (int i = 0; i < dominoes.length; ++i) {
            if (dominoes[i][0] < dominoes[i][1]) {
                res += counter[dominoes[i][0]][dominoes[i][1]]++;
            } else {
                res += counter[dominoes[i][1]][dominoes[i][0]]++;
            }
        }
        return res;
    }
}