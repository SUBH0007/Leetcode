class Solution {
    public int maxDifference(String s) {
         int[] count = new int[26];
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }
        int maxodd=0, mineven =Integer.MAX_VALUE;
        for(int i=0; i<count.length ; i++){
            if(count[i]%2==0 && count[i]<mineven && count[i] > 0){
                     mineven = count[i];
            }
             if(count[i]%2 == 1 && count[i]>maxodd && count[i] > 0){
                maxodd = count[i];
            }
        }
        return maxodd - mineven;
    }
}