package dynamicprogramming

fun maxProfit(prices: IntArray): Int {
    var minPrice = prices[0]
    var maxProfit = 0
    for (i in 1..prices.lastIndex) {
        minPrice = minOf(minPrice, prices[i])
        maxProfit = maxOf(maxProfit, prices[i] - minPrice)
    }
    return maxProfit
}

fun main() {
    println(maxProfit(intArrayOf(7,1,5,3,6,4)))
}
