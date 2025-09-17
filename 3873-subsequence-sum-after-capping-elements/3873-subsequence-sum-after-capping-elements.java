class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;

        // Sort ascendingly, as we explore the x ascendingly
        Arrays.sort(nums);
        boolean[] ans = new boolean[n];

        // Max value we care about is k
        boolean[] dp = new boolean[k+1];
        dp[0] = true;

        // Each elements <= n will be uncapped once.
        int i = 0;
        
        for(int x=1; x<=n; x++) {
            // Expand the uncapped
            for(; i < n && nums[i] < x; i++) {
                for(int j=k; j>=nums[i]; j--)
                    dp[j] = dp[j] || dp[j - nums[i]];
            }

            // Since the bigger elements are capped
            // We can just pick how many times it will be added
            // 0x, x, 2x, 3x, ... , (n - i)x
            int nCapped = n - i;
            for(int j=0; j<=nCapped; j++) {
                int times = j * x;
                if(times > k) break;

                // Set the ans[x-1] here.
                if(dp[k - times]) {
                    ans[x - 1] = true;
                    break;
                }
            }
        }
        return ans;
    }
}