class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder str = new StringBuilder(s);
        int i=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch=='('){
            st.push(i);
            }
            else if(ch==')'){
                if(!st.isEmpty() ){
                        st.pop();
                }
                else{
                    str.setCharAt(i,'*');
                }
            }
            i++;
        }
        while(!st.isEmpty()){
            str.setCharAt(st.pop(),'*');
        }
        return str.toString().replaceAll("\\*","");
    }
}
