class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> inarr = new ArrayList<>(i+1);
           for(int j=0;j<=i;j++){
            if(j==0 || j==i)
            {
            inarr.add(1);
            } 
           else{
            int num = arr.get(i-1).get(j) + arr.get(i-1).get(j-1);
            inarr.add(num);
           }
        }
        arr.add(inarr);
        }
        return arr;
    }
}