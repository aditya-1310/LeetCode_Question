class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int arrclone[] = arr.clone();
       Map<Integer,Integer> rankmap  = new HashMap<>();
       Arrays.sort(arrclone);
       int rank =1;
       for(int nums:arrclone){
        if(!rankmap.containsKey(nums)){
            rankmap.put(nums,rank);
            rank++;
        }
       }
        int newarr[] = new int[arr.length];
       for(int i=0;i<arr.length;i++){
            newarr[i] = rankmap.get(arr[i]);
       }

       return newarr;
    }
}