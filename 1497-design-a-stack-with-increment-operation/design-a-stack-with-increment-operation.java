class CustomStack {
    private List<Integer> st;
    private List<Integer> increments;
    private int maxsize;

    public CustomStack(int maxSize) {
        maxsize = maxSize;
        st = new ArrayList<>();
        increments = new ArrayList<>();
    }
    
    public void push(int x) {
        if(st.size() < maxsize) {
            st.add(x);
            increments.add(0);
        }
    }
    
    public int pop() {
        if(st.size()==0) return -1;

        int top = st.size()-1;
        if(top>0){
            increments.set(top-1,increments.get(top-1)+increments.get(top));
        }

        int topvalue= st.get(top) + increments.get(top);

        st.remove(top);
        increments.remove(top);

        return topvalue;

    }
    
    public void increment(int k, int val) {
        int index = Math.min(k,st.size())-1;
        if(index>=0){
            increments.set(index,increments.get(index)+val);
        }

    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */