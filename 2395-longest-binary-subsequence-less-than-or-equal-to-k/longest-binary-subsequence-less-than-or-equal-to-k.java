class Solution {
    public int longestSubsequence(String s, int k) {


        return rec(s.length()-1, 0,0, s.toCharArray(),k);
    }

    int rec(int index, int size, int ans, char[] arr, int k){

        if(index<0){
            return size;
        }

        if(arr[index]== '0'){
            return rec(index-1, size+1, ans, arr, k);
        }
        else{
            if(Math.pow(2,size)+ ans >k){
                return rec(index-1, size, ans, arr, k);
            }else{
                return rec(index-1, size+1, (int)Math.pow(2,size)+ans, arr, k);
            }
        }
    }
}