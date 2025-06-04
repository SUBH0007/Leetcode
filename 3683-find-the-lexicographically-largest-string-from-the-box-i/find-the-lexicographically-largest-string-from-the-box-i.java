class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1)return word;
        
        int l = word.length()-numFriends+1;
        int n = word.length();
        String best = "";

        for(char c = 'z' ; c >= 'a' ; c--)
        {
             int i = word.indexOf(c);
             if(i == -1)continue;

             for(int j = i ; j < n ; j++)
             {
                if(word.charAt(j) != c)continue;

                String sub = word.substring(j);
                if(sub.length() > l)sub = sub.substring(0,l);

                if(sub.compareTo(best) > 0)
                {
                    best = sub;
                }
             } 

             break;
        }

        
        return best;
    }
}