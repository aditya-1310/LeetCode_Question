class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<=9;i++){
        solve(i,n,arr);
        }
        return arr;
    }
    public void solve(int currind,int n,ArrayList<Integer>arr){
        if(currind>n) return;
        arr.add(currind);
        for(int app=0;app<=9;app++){ 
            int newnum =  currind*10+app;
            if(newnum >n) return;
            solve(newnum,n,arr);
        }
    }
}