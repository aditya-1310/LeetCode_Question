class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer ,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> y.b - x.b);
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            pq.add(new Pair(entry.getKey() ,entry.getValue()));
        }
        int arr [] = new int[k];
        for(int i=0;i<k;i++){
            arr[i] =pq.peek().a;
            pq.poll();
        }
    return arr;
    }
}
class Pair{
    int a,b;
    public Pair(int a,int b){
         this.a = a ;
         this.b = b;
    }
}