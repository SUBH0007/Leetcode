class Solution {
    public int minimumIndex(List<Integer> nums) {
         Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        
        int maxFreq = Collections.max(freq.values());
        int dominant = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxFreq) {
                dominant = entry.getKey();
                break;
            }
        }

       
        int countLeft = 0;
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                countLeft++;
            }
            int countRight = maxFreq - countLeft;

            
            if (countLeft * 2 > (i + 1) && countRight * 2 > (n - i - 1)) {
                return i;
            }
        }

        return -1;
    }
}