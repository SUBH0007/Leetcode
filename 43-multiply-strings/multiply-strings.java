class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int[] products = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                int product = n1 * n2;
                int sum = product + products[i + j + 1];
                products[i + j + 1] = sum % 10;
                products[i + j] += sum / 10;
            }
        }

        for (int num : products) {
            if (num == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(num);
        }

        return sb.toString();
    }
}