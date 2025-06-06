class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String ch : tokens){
            if(!ch.equals("+") && !ch.equals("-") &&
               !ch.equals("*") && !ch.equals("/") ){
                st.push(Integer.parseInt(ch));
            } else {
                int temp1 = st.pop();
                int temp2 = st.pop();
                int result;
                if(ch.equals("+")) {
                    result = temp2 + temp1;
                } else if(ch.equals("-")) {
                    result = temp2 - temp1;
                } else if(ch.equals("*")) {
                    result = temp2 * temp1;
                } else {
                    result = temp2 / temp1;
                }
                st.push(result);
            }
        }
        return st.peek();
    }
}