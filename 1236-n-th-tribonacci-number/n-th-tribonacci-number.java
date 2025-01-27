class Solution {
    public int tribonacci(int n) {
    
    int arr[] = new int [n+4];
    Arrays.fill(arr,-1);
    arr[0]=0;arr[1]=1;arr[2]=1;
    return trib(n,arr) ;
    }
    public int trib(int n , int arr[]){
        if(arr[n]!=-1) return arr[n];
        return arr[n]=trib(n-1,arr)+ trib(n-2,arr)+trib(n-3,arr);
    }
}