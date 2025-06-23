class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            for (long num : generatePalindromes(length)) {
                if (isKPalindrome(num, k)) {
                    sum += num;
                    count++;
                    if (count == n) return sum;
                }
            }
            length++;
        }

        return sum;
    }

    // Generate base-10 palindromes of a given length
    private List<Long> generatePalindromes(int length) {
        List<Long> palindromes = new ArrayList<>();

        int half = (length + 1) / 2;
        long start = (long)Math.pow(10, half - 1);
        long end = (long)Math.pow(10, half);

        for (long i = start; i < end; i++) {
            String firstHalf = Long.toString(i);
            String secondHalf = new StringBuilder(firstHalf.substring(0, length % 2 == 0 ? firstHalf.length() : firstHalf.length() - 1)).reverse().toString();
            String full = firstHalf + secondHalf;
            palindromes.add(Long.parseLong(full));
        }

        return palindromes;
    }

    // Check if a number is a palindrome in base-k
    private boolean isKPalindrome(long num, int k) {
        String baseK = toBaseK(num, k);
        return isPalindrome(baseK);
    }

    // Convert number to base-k
    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    // Check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}