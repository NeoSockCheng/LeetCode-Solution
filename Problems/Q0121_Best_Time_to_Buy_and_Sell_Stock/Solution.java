package Problems.Q0121_Best_Time_to_Buy_and_Sell_Stock;

class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buy);
            }
        }
        return profit;
    }
}
// question: given stock prices over days, find the maximum profit where yuo choose 1 day to buy and another day to sell
// solution: sliding window, start from buy = 0 , profit = 0;
// while iterating through the array, when the prices<buy, update buy
// when prices>buy, update profit = max(profit, prices-buy)