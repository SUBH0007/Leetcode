class Solution {
    public int[] findEvenNumbers(int[] digits) {
         Set<Integer> set = new HashSet<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<digits.length;i++){
            map.put(digits[i], map.getOrDefault(digits[i], 0) + 1);
        }
        for(int i=100;i<1000;i++){
            if(i%2!=0){
                continue;
            }
            int first=i%10;
            int sec=(i/10)%10;
            int third=i/100;
            if(first==sec && sec==third && map.containsKey(first)){
                if(map.get(first)<3){
                    continue;
                }
                set.add(i);
            }
            else if(first==sec && map.containsKey(first)){
                if(map.get(first)<2){
                    continue;
                }
                if(map.containsKey(third)){
                    set.add(i);
                }
            }
            else if(sec==third && map.containsKey(sec)){
                if(map.get(sec)<2){
                    continue;
                }
                if(map.containsKey(first)){
                    set.add(i);
                }
            }
            else if(first==third && map.containsKey(first)){
                if(map.get(first)<2){
                    continue;
                }
                if(map.containsKey(sec)){
                    set.add(i);
                }
            }
            else if(map.containsKey(first) && map.containsKey(sec) && map.containsKey(third)){
                set.add(i);
        }
    }
    int res[] = new int[set.size()];
        int i=0;
        for(int x:set){
            res[i]=x;
            i++;
        }
        Arrays.sort(res);
        return res;
    }
}