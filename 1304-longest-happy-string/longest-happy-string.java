class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y)->(y.count - x.count));
    
    if(a>0){
        pq.add(new pair(a,'a'));
    }
    if(b>0){
        pq.add(new pair(b,'b'));
    }
    if(c>0){
        pq.add(new pair(c,'c'));
    }
    StringBuilder ans = new StringBuilder();
    while(!pq.isEmpty()){
        pair p = pq.poll();
        int count = p.count;
        char character = p.character;
        if(ans.length()>=2 &&
        ans.charAt(ans.length()-1 )== p.character &&
        ans.charAt(ans.length()-2)== p.character){
            if(pq.isEmpty()) break;
            pair temp  = pq.poll();
            ans.append(temp.character);
            if(temp.count-1>0){
                pq.add(new pair (temp.count -1,temp.character));
            }
        }else{
            count --;
            ans.append(character);
        }
        if(count >0){
            pq.add(new pair(count,character));
        }

    }
        return ans.toString();

}
}
class pair {
    int count =0;
    char character;
    pair(int count,char character){
        this.count=count;
        this.character = character;
    }
}