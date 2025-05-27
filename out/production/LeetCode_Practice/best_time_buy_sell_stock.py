class Solution(object):
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        if not prices:
            return 0
        
        # profit keeps track of profits after completing transactions
        # balance keeps track of the balance after buying a stock
        profit, balance = 0, -prices[0]

        for price in prices:
            profit = max(profit, balance + price - fee) # update profit, do nothing or sell stock and collect profit minus fee
            balance = max(balance, profit - price)  # update balance: Buy stock or keep holding

        return profit

if __name__ == "__main__":
    prices = [1,3,2,8,4,9]
    fee = 2

    sol = Solution()

    res = sol.maxProfit(prices, fee)

    print(res)

# Problem description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/?envType=study-plan-v2&envId=leetcode-75

