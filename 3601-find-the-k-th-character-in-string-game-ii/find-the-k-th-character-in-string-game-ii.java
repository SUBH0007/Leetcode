class Solution {
    public char kthCharacter(long k, int[] operations) {
        long currentK = k;
        int totalShifts = 0;

       
        for (int i = operations.length - 1; i >= 0; i--) {
            
            if (i >= 47) { 
                continue; 
            }

            
            long halfLength = (1L << i);

           
            if (currentK > halfLength) {
                currentK -= halfLength; 
                if (operations[i] == 1) {
                    totalShifts++;
                }
            }
            
        }

        
        return (char) ('a' + (totalShifts % 26));
    }
}