class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b)->Double.compare(b,a));
        double sum =0;
        for(int i:nums){
            sum+=i;
            pq.add((double)i);
        }
        double half = sum/2;
        double redu =0;
        int i=0;
        while(redu<half){
           Double largest = pq.peek();
           pq.remove();
            pq.add(largest/2);
            redu +=largest/2;
                i++;
        }
        return i;
    }
}