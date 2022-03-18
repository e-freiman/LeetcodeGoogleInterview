package dynamicprogramming

private const val NOT_INITIALIZED = -1

private var memo = intArrayOf()

fun dpTopDown(coins: IntArray, amount: Int): Int {
    if (memo[amount] != NOT_INITIALIZED) {
        return memo[amount]
    }
    var min = Int.MAX_VALUE
    for(coin in coins) {
        if (coin == amount) {
            return 1
        }
        if (coin < amount) {
            min = minOf(min, dpTopDown(coins, amount - coin))
        }
    }
    val ret = if (min == Int.MAX_VALUE) Int.MAX_VALUE else min + 1
    memo[amount] = ret
    return ret
}

fun dpBottomUp(coins: IntArray, amount: Int): Int {
    for (curAmount in 1..amount) {
        var min = Int.MAX_VALUE
        for(coin in coins) {
            if (curAmount == coin) {
                min = 0
                break
            }
            if (curAmount - coin > 0) {
                min = minOf(min, memo[curAmount - coin])
            }
        }
        memo[curAmount] = if (min == Int.MAX_VALUE) Int.MAX_VALUE else min + 1
    }
    return memo[amount]
}

// O(amount * coins.size)
fun coinChange(coins: IntArray, amount: Int): Int {
    if (amount == 0) {
        return 0
    }
    memo = IntArray(amount + 1) {NOT_INITIALIZED}
    //val ret = dpTopDown(coins, amount)
    val ret = dpBottomUp(coins, amount)
    return if (ret == Int.MAX_VALUE) -1 else ret
}

fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 11))
}



