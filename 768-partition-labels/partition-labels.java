class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> charStartEnd = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charStartEnd.containsKey(c)) {
                charStartEnd.get(c)[1] = i;
            } 
            else {
                charStartEnd.put(c, new int[]{i, i});
            }
        }
        
        
        List<int[]> intervals = new ArrayList<>();
        for (Map.Entry<Character, int[]> entry : charStartEnd.entrySet()) {
            intervals.add(entry.getValue());
        }
        
        
        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        
        List<int[]> intervalReDefined = new ArrayList<>();
        intervalReDefined.add(intervals.get(0));
        int idx = 0;
        for (int i = 1; i < intervals.size(); i++) {

            int[] current = intervalReDefined.get(idx);

            int a = intervals.get(i)[0];
            int b = intervals.get(i)[1];

            if (a >= current[0] && a <= current[1]) {
                current[1] = Math.max(current[1], b);
            } 
            else {
                intervalReDefined.add(new int[]{a, b});
                idx++;
            }
        }
        
     
        List<Integer> res = new ArrayList<>();
        for (int[] interval : intervalReDefined) {
            res.add(interval[1] - interval[0] + 1);
        }
        
        return res;
    }
}