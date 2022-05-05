package leetcode.`best-time-to-buy-and-sell-stock`

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var money = 0
        var max = 0
        for (i in prices.lastIndex downTo 0){
            max = Math.max(max, prices[i])
            money = Math.max(money, max - prices[i])
        }
        return money
    }
}