class MyCalendarTwo {
        private ArrayList<int[]> booking;
        private ArrayList<int[]> overlapbooking;
        public boolean doesoverlap(int start1,int end1,int start2,int end2){
            return Math.max(start1,start2)<Math.min(end1,end2);
        }
        public int [] getoverlap(int start1,int end1,int start2,int end2){
            return new int[] {Math.max(start1,start2),Math.min(end1,end2)};
        }


    public MyCalendarTwo() {
        booking = new  ArrayList<>();
        overlapbooking = new  ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int [] book: overlapbooking){
            if(doesoverlap(book[0],book[1],start,end)){
                return false;
            }
        }
        for(int []book :booking){
            if(doesoverlap(book[0],book[1],start,end)){
                overlapbooking.add(getoverlap(book[0],book[1],start,end));
            }
        }

        booking.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */