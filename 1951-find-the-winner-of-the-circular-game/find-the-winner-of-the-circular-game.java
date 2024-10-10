class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> arr  = new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(i);
        }
    int i=0;
    while(arr.size() >1){
        int ind = (i+k-1)%arr.size();
        
        arr.remove(ind);
        i=ind;
    }
    return arr.get(0);
    }
}