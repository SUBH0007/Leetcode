class Solution {
    public int maxDiff(int num) {
        String num1 = String.valueOf(num);
        String maxStr = num1;
        String minStr = num1;

        // to make max val
        for (int i = 0; i < num1.length(); i++) {
            char ch = num1.charAt(i);
            if (ch != '9') {
                maxStr = num1.replace(ch, '9');
                break;
            }
        }
        //to make min val
        char first = num1.charAt(0);
        if (first != '1') {
            minStr = num1.replace(first, '1');
        } 
        else {
            for (int i = 1; i < num1.length(); i++) {
                char ch = num1.charAt(i);
                if(ch != '0' && ch != first) {       // if char is not zero then we have to make it zero if its not equal to firstchar 
                    minStr = num1.replace(ch, '0');
                     break;
                }
            }
        }

        int a = Integer.parseInt(maxStr);

        int b = Integer.parseInt(minStr);
        return a - b;
    }
}