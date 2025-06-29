class Solution {
    public int[] constructDistancedSequence(int n) {
        // Result array jo final sequence store karega
        int[] result = new int[n * 2 - 1];

        // Numbers array jo n se 1 tak ke numbers store karega
        int[] numbers = new int[n];
        int temp = n;
        for (int i = 0; i < n; i++) {
            numbers[i] = temp - i; // Numbers ko descending order mein store karo
        }

        // Used array jo track karega ki kaunse numbers use ho chuke hain
        boolean[] used = new boolean[n];

        // Backtracking function call karo
        checkValid(result, used, numbers, 0);

        // Final result return karo
        return result;
    }

    public boolean checkValid(int result[], boolean used[], int numbers[], int index) {
        // Agar pura result array fill ho gaya hai, toh return true
        if (index == result.length) {
            return true;
        }

        // Agar current index pe already kuch value hai, toh next index pe move karo
        while (index < result.length && result[index] != 0) {
            index++;
        }

        // Agar pura array traverse ho gaya hai, toh return true
        if (index == result.length) {
            return true;
        }

        // Har number ko try karo
        for (int i = 0; i < used.length; i++) {
            // Agar number use nahi hua hai
            if (!used[i]) {
                // Agar number 1 hai ya uska pair (index + numbers[i]) valid hai
                if (numbers[i] == 1 || (index + numbers[i] < result.length && result[index + numbers[i]] == 0)) {
                    // Current index pe number daalo
                    result[index] = numbers[i];

                    // Agar number 1 nahi hai, toh uska pair bhi daalo
                    if (numbers[i] != 1) {
                        result[index + numbers[i]] = numbers[i];
                    }

                    // Number ko used mark karo
                    used[i] = true;

                    // Recursively next index pe check karo
                    if (checkValid(result, used, numbers, index + 1)) {
                        return true; // Agar valid sequence mil gaya, toh return true
                    } else {
                        // Backtracking: Agar valid sequence nahi mila, toh changes undo karo
                        result[index] = 0;
                        if (numbers[i] != 1) {
                            result[index + numbers[i]] = 0;
                        }
                        used[i] = false;
                    }
                }
            }
        }

        // Agar koi bhi number valid nahi hai, toh return false
        return false;
    }
}