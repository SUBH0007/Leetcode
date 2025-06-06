class Solution {
    public String robotWithString(String s) {
        int[] ar = new int[26];
        for (char ch: s.toCharArray()) ar[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Stack<Character> stack = new Stack();
        int n = s.length();
        while (i < n) {
            int min = 26;
            for (int k = 0; k < 26; ++k) {
                if (ar[k] > 0) {
                    min = k;
                    break;
                }
            }
            while (!stack.isEmpty() && (stack.peek() - 'a') <= min) sb.append(stack.pop());
            while (i < n && (s.charAt(i) - 'a') != min) {
                stack.push(s.charAt(i));
                ar[s.charAt(i) - 'a']--;
                ++i;
            }
            sb.append(s.charAt(i));
            ar[min]--;
            ++i;
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }
}