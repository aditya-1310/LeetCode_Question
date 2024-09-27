class MyCalendar {

    // List<int[]>calender;
    // public MyCalendar() {
    //    calender = new ArrayList<>();
    // }
    
    // public boolean book(int start, int end) {
    //     for(int []curr : calender){
    //         if(!(end<=curr[0] || start >=curr[1])){
    //         return false;
    //         } 
    //     }
    //     calender.add(new int[]{start,end});
    //     return true;

    // }
    // ----------------------//////2 approch
    TreeSet<int[]>st;
    public MyCalendar(){
        st= new TreeSet<>((a,b)->a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);
    }
    public boolean book(int start, int end) {
       int [] curr = new int []{start,end};
       int [] next = st.ceiling(curr);
       if(next!=null && next[0]<end) return false;

       int [] prev = st.floor(curr);
       if(prev!=null && start<prev[1]) return false;

       st.add(new int[]{start,end});
       return true;              
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */