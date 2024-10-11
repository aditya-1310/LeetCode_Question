class Solution {
    public int smallestChair(int[][] times, int targetF) {
        int n = times.length;
     int [][] friend = new int[n][3];
     for(int i=0;i<n;i++){
        friend[i][0] = times[i][0];
        friend[i][1] = times[i][1];
        friend[i][2] =i;
     }

     Arrays.sort(friend,(a,b)->a[0]-b[0]);

     PriorityQueue<Integer> avaliable = new PriorityQueue<>();
     for(int i=0;i<n;i++){
        avaliable.offer(i);
     }

      PriorityQueue<int []> leavingtime = new PriorityQueue<>((a,b)->a[0]-b[0]);

     for(int i=0;i<n;i++){
        int arrival = friend[i][0];
        int leaving = friend[i][1];
        int friendindex = friend[i][2];

        while(!leavingtime.isEmpty() && leavingtime.peek()[0]<=arrival){
            avaliable.offer(leavingtime.poll()[1]);
         }
         int assignchair = avaliable.poll();

         if(targetF == friendindex){
            return assignchair;
         }
         leavingtime.offer( new int[]{leaving,assignchair});
     }

     return -1;
    }
}