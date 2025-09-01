class Solution {
    public boolean isEq(int[] a,int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] freq=new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        int wsize=s1.length();
        for(int i=0;i<s2.length();i++){
            int widx=0;
            int idx=i;
            int[] wfreq=new int[26];
            while(widx<wsize && idx<s2.length()){
                wfreq[s2.charAt(idx)-'a']++;
                widx++;idx++;
            }
            if(isEq(freq,wfreq)){
                return true;
            }
        }
        return false;
    }
}