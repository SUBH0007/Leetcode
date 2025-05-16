class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
         List<String> res = new ArrayList<>();
        int i=0;
        while(i<groups.length){
            int num = groups[i];
            res.add(words[i]);
            while(i<groups.length && groups[i]==num) i++;
        }

        return res;
    }
}