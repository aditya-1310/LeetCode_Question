class Solution {
    public int minInsertions(String s) {
      Stack<Character> st = new Stack<>();
      int insert =0;
      int i=0;
      while(i<s.length()){
        char ch = s.charAt(i);
        if(ch =='('){
            st.push(ch);
        }
        else  if(ch ==')'){
           
            if(i+1<s.length() && s.charAt(i+1)==')'){
                if(!st.isEmpty() && st.peek()=='(') {
                    st.pop();
                }
                else insert++;

                i++;
            }else{
                if(!st.isEmpty() && st.peek()=='(') {
                    st.pop();
                    insert++;
                }
                else{
                    insert+=2;
                }
            }

        }
        i++;
      }
      while(!st.isEmpty()){
        st.pop();
        insert+=2;
      }

      return insert;
    }
}
