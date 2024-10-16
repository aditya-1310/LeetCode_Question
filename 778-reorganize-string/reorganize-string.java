class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> feqmap  = new HashMap<>();
        for(char a:s.toCharArray()){
            feqmap.put(a,feqmap.getOrDefault(a,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->feqmap.get(b)-feqmap.get(a));
        pq.addAll(feqmap.keySet());
        StringBuilder str = new StringBuilder();
        while(pq.size()>=2){
            char ch1 = pq.poll();
            char ch2 = pq.poll();
            str.append(ch1);
            str.append(ch2);
            feqmap.put(ch1,feqmap.get(ch1)-1);
            feqmap.put(ch2,feqmap.get(ch2)-1);

            if(feqmap.get(ch1)>0) pq.add(ch1);
            if(feqmap.get(ch2)>0) pq.add(ch2);
        }
        if(!pq.isEmpty()){
            char ch = pq.poll();
            if(feqmap.get(ch)>1) return "";
            str.append(ch);
        }


        return str.toString();
    }
}