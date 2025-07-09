class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        // Computing the gaps between Meetings;
        int n = endTime.length;
        int [] gaps = new int [n+1];
        gaps[0] = startTime[0];
        for(int i=1;i<n;i++){
            gaps[i] = startTime[i] - endTime[i-1];
        }
        gaps[n] = eventTime - endTime[n-1];
        
        // Sliding window Approach
        int max = 0;
        int winSum = 0;
        int left=0, right=0;
        int winMax = k+1;
        while(right <= n){
            winSum += gaps[right];
            if(right - left + 1 > winMax){
                winSum-=gaps[left];
                left++;
            }
            if(right - left + 1 == winMax){
                max = Math.max(max,winSum);
            }
            right++;
        }
        return max;
    }
}