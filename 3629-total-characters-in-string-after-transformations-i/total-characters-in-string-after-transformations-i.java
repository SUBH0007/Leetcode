class Solution {
    public int lengthAfterTransformations(String s, int t) {
        String res = "";
        int mod = (int) (Math.pow(10, 9)) + 7;
        int temp[] = new int[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
        }
        while (t != 0) {
            int newcount[] = new int[26];

            for (int i = 0; i < 26; i++) 
            {
                if (temp[i] > 0 && i == 25) 
                {
                    res = res + "ab";
                    newcount[0] = (newcount[0] + temp[i])%mod;
                    newcount[1] = (newcount[1] + temp[i])%mod;
                } 
                else if (temp[i] > 0 && i != 25) {
                    newcount[i + 1] = (newcount[i + 1] + temp[i])%mod;
                    res = res + (char) (i + 97 + 1);
                }
            }

            t--;
            // s = res;
            res = "";
            temp = newcount;
            //            count=s.length()%mod;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                count = (count + temp[i])%mod;
            }
        }
        return count;
    }
}