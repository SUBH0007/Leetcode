class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tg=0,tc=0;
        for(int i=0;i<gas.length;i++){
            tg+=gas[i];
            tc+=cost[i];
        }
        if(tc>tg){
            return -1;
        }
        int cg=0;
        int st=0;
        for(int i=0;i<gas.length;i++){
            cg+=gas[i]-cost[i];
            if(cg<0){
                cg=0;
                st=i+1;
            }
        }
        return st;
    }
}