class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int n = cost.size();
        vector<int> dp(n, -1);
        return min(minCost(n-1 , dp , cost) , minCost(n-2 , dp , cost));
    }
private:
    int minCost(int i , vector<int>& dp , vector<int>& cost){
        if(i < 0){
            return 0;
        }

        if(dp[i] != -1)
            return dp[i];

        int a = minCost(i-1 , dp , cost);
        int b = minCost(i-2 , dp , cost);

        return dp[i] = min(a,b) + cost[i];
    }
};