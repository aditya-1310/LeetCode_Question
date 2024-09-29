class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length;i++){
            st.push(s[i]);
        }
        int index =0;
        while(!st.isEmpty()){
            s[index] = st.pop();
            index++;
        }
        System.out.println(s);
       
    }
    public void reverse(Stack<Character>st){
        if(st.isEmpty()) return ;
        char top = st.peek();
        st.pop();
        reverse(st);
        insertatbottom(st,top);       
    }
    public void insertatbottom(Stack<Character>st,char s){
        if(st.isEmpty()) {
            st.push(s);
            return;
        }
        char top = st.peek();
        st.pop();
        insertatbottom(st,s);
    }

}