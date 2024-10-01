class Solution {
    public boolean canArrange(int[] arr, int k) {
      int mp[] = new int[k];
      for(int nums:arr){
        int rem =(nums %k+k)%k;
        mp[rem]++;
      }
    if(mp[0]%2!=0){
        return false;
    }
    for(int i=1;i<=k/2;i++){
        int curr= k-i;
        if(mp[curr]!=mp[i])return false;
    }
    return true;
    }
}