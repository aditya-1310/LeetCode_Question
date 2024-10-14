class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }

        while (k > 0) {
            int var = pq.peek();
            score += pq.peek();
            pq.remove();
            pq.add((int) Math.ceil((var / 3.0)));
            k--;
        }
        return score;
    }

}
