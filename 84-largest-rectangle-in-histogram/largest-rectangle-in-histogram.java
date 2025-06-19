class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nsr=new int[heights.length];
        int[] nsl=new int[heights.length];
        Stack<Integer> s=new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while((!s.isEmpty())&& (heights[s.peek()]>=heights[i])){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=heights.length;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        s=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while((!s.isEmpty())&& (heights[s.peek()]>=heights[i])){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        int area=0;
        int maxarea=0;
        for(int i=0;i<heights.length;i++){
            area=heights[i]*(nsr[i]-nsl[i]-1);
            maxarea=Math.max(area,maxarea);
        }
        return maxarea;
    }
}