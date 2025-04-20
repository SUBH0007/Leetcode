class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int x = 0, y = 0, k = 0;
        while (list.size() != m * n) {
            list.add(matrix[x][y]);
            matrix[x][y] = 1000;
            if (x+dir[k][0] < 0 || y+dir[k][1] < 0 || x+dir[k][0] >= m || y+dir[k][1] >= n || matrix[x+dir[k][0]][y+dir[k][1]] == 1000) {
                k = (k + 1) % 4;
                x = x + dir[k][0];
                y = y + dir[k][1];
            }
            else{
                x = x + dir[k][0];
                y = y + dir[k][1];
            }
        }
        return list;
    }
}