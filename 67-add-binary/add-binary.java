class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        
        if (n < m) {
            a = "0".repeat(m - n) + a;
        } else if (m < n) {
            b = "0".repeat(n - m) + b;
        }

        int carry = 0;
        StringBuilder ans = new StringBuilder();

       
        for (int i = a.length() - 1; i >= 0; i--) { 
            int sum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            ans.append(sum % 2);
            carry = sum / 2;
        }

       
        if (carry != 0) {
            ans.append("1");
        }

        return ans.reverse().toString(); 
    }
}