class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int gift :gifts){
            pq.add(gift);
        }
        long sc =0;
        while(k>0){
            int var=pq.peek();
            pq.remove();
            pq.add((int)Math.sqrt(var));
            k--;
        }
        while(!pq.isEmpty()){
            sc+=pq.peek();
            pq.remove();
        }
        return sc;
    }
}