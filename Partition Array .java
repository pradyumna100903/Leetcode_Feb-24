class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Length of the input array
        int n = arr.length;

        // Dynamic programming table to store maximum sum at each position
        int[] dp = new int[n + 1];

        // Iterate through the array elements
        for (int i = 0; i < n; i++) {
            int curMax = 0, curSum = 0;

            // Iterate over the last k elements or until the beginning of the array
            for (int j = i; j >= Math.max(0, i - k + 1); j--) {
                // Update the maximum value in the current partition
                curMax = Math.max(curMax, arr[j]);

                // Calculate the current sum considering the maximum value in the partition
                int cur = curMax * (i - j + 1) + dp[j];

                // Update the current sum if the new one is greater
                curSum = Math.max(curSum, cur);
            }

            // Update the dynamic programming table with the maximum sum at the current position
            dp[i + 1] = curSum;
        }

        return dp[n];
    }
}
