class Solution {
    boolean searchin(int matrix[][],int target,int mid){
        int x=0;
        int y=matrix[0].length-1;
                while(x<=y){
                    int cen=x+(y-x)/2;
                    if(target==matrix[mid][cen]){
                        return true;
                    }else if(target>matrix[mid][cen]){
                        x=cen+1;
                    }else{
                        y=cen-1;
                    }
                }
                return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int st=0;
        int end=matrix.length-1;
        int m=matrix.length;
        int n=matrix[0].length;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][n-1]){
                return searchin(matrix,target,mid);
            }else if(target>matrix[mid][n-1]){
                st=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
}