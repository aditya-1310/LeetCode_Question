class Solution {
    public int[] sortArray(int[] nums) {
        int l =0;
        int r  = nums.length-1;
        mergesort(nums,l,r);
        return nums;
    }
    public void mergesort(int nums[],int l,int r){
        if(l>=r) return ;
        int m = l+(r-l)/2;
        mergesort(nums,l,m);
        mergesort(nums,m+1,r);
        merge(nums,l,m,r);
    }
    public void merge(int [] nums,int l,int mm ,int r){
        int n = mm-l+1;
        int m  = r-mm;
        int L [] = new int[n];
        int R[]= new int[m];
        int k =l;
        for(int i=0;i<n;i++){
            L[i] =nums[k];
            k++;
        }
        for(int i=0;i < m;i++){
            R[i] =nums[k];
            k++;
        }

        int i=0;
        int j=0;
         k =l;
        while(i<n && j<m){
            if(L[i]<=R[j]){
                nums[k] = L[i];
                i++;
                k++;

            }
            else{
                nums[k] = R[j];
                j++;
                k++;
            }
        }
        while(i<n){
            nums[k] = L[i];
            k++;
            i++;
        }
        while(j<m){
            nums[k] = R[j];
             k++;
            j++;
        }

    }
}