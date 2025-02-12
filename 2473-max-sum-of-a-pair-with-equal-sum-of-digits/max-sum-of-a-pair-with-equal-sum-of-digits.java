class Solution {
    public int maximumSum(int[] nums) {
        int arr[] = cal(nums);
        int maxmax =Integer.MIN_VALUE;
        boolean  hasDuplicate = false;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
           int maxsum =-1;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> ass = entry.getValue();
            if (ass.size() < 2) continue;
            hasDuplicate = true;
           int firstmax = Integer.MIN_VALUE;
           int secondmax = Integer.MIN_VALUE;
           for(int i=0;i<ass.size();i++){
            int num = nums[ass.get(i)];
            if(num > firstmax){
                secondmax = firstmax;
                firstmax = num;
            }else if(num > secondmax){
                secondmax = num;
            }
           }

           if(secondmax != Integer.MIN_VALUE){
            maxsum = Math.max(maxsum , firstmax + secondmax);
           }


            }
        return maxsum;
    }
    public int [] cal(int []nums){
        int na [] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int digi =0;
            while(num>0){
                digi +=num%10;
                num /=10;
            }
            na[i] = digi;
        }
        return na;
    }
}