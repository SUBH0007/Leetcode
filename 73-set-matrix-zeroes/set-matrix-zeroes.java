class Solution {
    public void setZeroes(int[][] matrix) {
         boolean firstZero = false;

        for(int i = 0; i < matrix.length; i++){

            if(matrix[i][0] == 0) firstZero = true;
            for(int j = 1; j < matrix[0].length; j++){
                // if 0 found, uski row & colke first element 0 bna do
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[0].length - 1; j >= 1; j--){
                // check , if that row or col have first element 0
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }

            if(firstZero){
                matrix[i][0] = 0;
            }
        }
    }
}