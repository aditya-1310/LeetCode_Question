class Solution {
    public List<Integer> lexicalOrder(int n) {
       ArrayList<Integer> arr = new ArrayList<>();
       for(int i=1;i<=9;i++){
        solve(i,n,arr);
       }
       return arr;
    }
    public void solve(int s, int e, ArrayList<Integer> result){
        if(s>e) return;
        result.add(s);
        for(int ap=0;ap<=9;ap++){
            int newn = (s*10)+ap;
            if(newn>e) return ;
            solve(newn,e,result);
        }
        
    }
}