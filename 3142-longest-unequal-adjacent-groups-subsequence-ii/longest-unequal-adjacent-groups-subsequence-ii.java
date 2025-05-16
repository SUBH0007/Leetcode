class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        boolean[][] checkHam = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(check(words[i],words[j],groups[i],groups[j])){
                    checkHam[i][j]=true;
                }
            }
        }
        int ind  = n-1;
        int max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = n-1;i>=0;i--){
            for(int j = n-1; j > i; j--){
                if(checkHam[i][j]==true){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    if(dp[i]>max){
                        max=dp[i];
                        ind=i;
                    }
                }
            }
            // System.out.print(dp[i]+" ");
        }
        List<String> ans = new ArrayList<String>();
        ans.add(words[ind]);
        max -= 1;
        int pre = ind;
        for(int i = ind+1; i < n; i++){
            if(checkHam[pre][i] && dp[i]==max){
                ans.add(words[i]);
                max-=1;
                pre=i;
            }
        }
        return ans;
    }
    public boolean check(String word1, String word2,int grp1, int grp2 ){
        if(word1.length()!=word2.length() ){
            return false;
        }
        if(grp1==grp2){
            return false;
        }
        int n = word1.length();
        int c = 0;
        for(int i = 0; i < n; i++){
            int c1 = word1.charAt(i);
            int c2 = word2.charAt(i);
            if(c1!=c2){
                c++;
            }
            if(c>1){
                return false;
            }
        }
        if(c==0){
            return false;
        }
        return true;
    }
}