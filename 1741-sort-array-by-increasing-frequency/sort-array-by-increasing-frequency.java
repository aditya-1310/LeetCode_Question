class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        PriorityQueue<value> pq = new PriorityQueue<>(new valuecomparator());

           for(Map.Entry<Integer,Integer> st :mp.entrySet()){
            pq.add(new value(st.getKey(),st.getValue()));
           }

           int arr [] = new int[nums.length];int index=0;
           while(!pq.isEmpty()){
            value sm = pq.remove();
            int keymain = sm.key;
            int valmain = sm.val;

            for(int i=0;i<keymain;i++){
                arr[index++] = valmain;
            }
           }

           return arr;
    }

    class value{
        int val;
        int key;

        public  value (int val, int key){
            this.val = val;
            this.key = key;
        }
    }
    class valuecomparator implements Comparator<value>{
        @Override
        public int compare(value v1 , value v2){
            if(v1.key == v2.key ) {
                return v2.val - v1.val;  
            }
            
                return v1.key - v2.key;
            
         }
    }
}