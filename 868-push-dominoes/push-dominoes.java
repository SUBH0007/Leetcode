class Solution {
    public String pushDominoes(String dominoes) {
         char[] arr = dominoes.toCharArray();
        int n = arr.length;
        int left = 0;

        while (left < n) {
            if (arr[left] == '.') {
                int right = left;
                while (right < n && arr[right] == '.') right++;

                char leftPush = (left - 1 >= 0) ? arr[left - 1] : 'L';
                char rightPush = (right < n) ? arr[right] : 'R';

                if (leftPush == rightPush) {
                    // Fill with same direction
                    for (int k = left; k < right; k++) {
                        arr[k] = leftPush;
                    }
                } else if (leftPush == 'R' && rightPush == 'L') {
                    // Fill from both ends inward
                    int l = left, r = right - 1;
                    while (l < r) {
                        arr[l++] = 'R';
                        arr[r--] = 'L';
                    }
                    // middle stays '.'
                }
                // else: L...R => leave as is

                left = right;
            } else {
                left++;
            }
        }

        return new String(arr);
    }
}