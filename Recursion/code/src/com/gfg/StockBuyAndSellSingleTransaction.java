package com.gfg;

public class StockBuyAndSellSingleTransaction {
    public static int maximumProfit(int[] prices) {
        // Variable to store the maximum profit found so far
        int ans = 0;

        // 'min' keeps track of the index of the minimum price seen so far
        int min = 0;

        // Iterate through the prices starting from the second day (index 1)
        for (int i = 1; i < prices.length; i++) {

            // If current price is greater than the minimum price seen so far,
            // and 'min' index is before current index, calculate profit
            if (prices[min] < prices[i] && min < i) {
                // Update maximum profit if the current profit is higher
                ans = Math.max(ans, prices[i] - prices[min]);
            } else {
                // If current price is less than or equal to prices[min],
                // update 'min' to the current index (new lowest price)
                min = i;
            }
        }

        // Return the maximum profit that can be achieved
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(maximumProfit(new int[]{7, 10, 1, 3, 6, 9, 2}));
    }
}
