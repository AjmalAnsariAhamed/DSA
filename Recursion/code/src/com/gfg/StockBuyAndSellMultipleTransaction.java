package com.gfg;

public class StockBuyAndSellMultipleTransaction {
    public static int maximumProfit(int[] prices) {
        // Create a memoization table to store intermediate results.
        // dp[i][0] -> maximum profit at day 'i' if we are in a "sell" state (i.e., we own a stock)
        // dp[i][1] -> maximum profit at day 'i' if we are in a "buy" state (i.e., we can buy a stock)
        Integer[][] dp = new Integer[prices.length][2];

        // Start from day 0 with the option to buy
        return maximumProfit(prices, 0, 1, dp);
    }

    public static int maximumProfit(int[] prices, int index, int buy, Integer[][] dp) {
        // Base case: If we've reached the end of the prices array, no profit can be made
        if (index == prices.length) {
            return 0;
        }

        // If the result is already computed for this state, return it to avoid recomputation
        if (dp[index][buy] != null) {
            return dp[index][buy];
        }

        int profit = 0;

        if (buy == 1) {
            // Option 1: Buy the stock at current index and move to the next day in sell state
            // Option 2: Skip buying the stock
            profit = Math.max(-prices[index] + maximumProfit(prices, index + 1, 0, dp), // Buy
                    maximumProfit(prices, index + 1, 1, dp)                    // Skip
            );
        } else {
            // Option 1: Sell the stock at current index and move to the next day in buy state
            // Option 2: Skip selling the stock
            profit = Math.max(prices[index] + maximumProfit(prices, index + 1, 1, dp),  // Sell
                    maximumProfit(prices, index + 1, 0, dp)                   // Skip
            );
        }
        // Store the result in the memoization table
        dp[index][buy] = profit;

        return profit;
    }
    public static void main(String[] args) {
        System.out.println(maximumProfit(new int[]{4, 2, 2, 2, 4}));
    }
}
