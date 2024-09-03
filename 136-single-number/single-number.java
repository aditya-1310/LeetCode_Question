class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> mm = new HashMap();
        for(int i=0;i<nums.length;i++) {
            mm.put(nums[i],mm.getOrDefault(nums[i],0)+1);
        }
        Set<Integer> ss = mm.keySet();
        for(int s :ss){
            if(mm.get(s)==1) return s;
        }

        return -1;
        }
    }
