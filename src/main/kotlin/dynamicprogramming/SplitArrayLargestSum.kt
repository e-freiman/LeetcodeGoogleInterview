package dynamicprogramming

private var memo = arrayOf<IntArray>()

fun dp(nums: IntArray, m: Int, index: Int): Int {
    if (memo[m][index] != -1) {
        return memo[m][index]
    }
    if (m == 1) {
        var sum = 0
        for (i in index .. nums.lastIndex) {
            sum += nums[i]
        }
        memo[m][index] = sum
        return sum
    }
    var sum = nums[index]
    var bestDivide = Int.MAX_VALUE
    for (i in index + 1 .. nums.lastIndex) {
        val divide = maxOf(sum, dp(nums, m - 1, i))
        bestDivide = minOf(divide, bestDivide)
        sum += nums[i]
    }
    memo[m][index] = bestDivide
    return bestDivide
}

fun splitArray(nums: IntArray, m: Int): Int {
    memo = Array(m + 1) { IntArray(nums.size) { -1 } }
    return dp(nums, m, 0)
}

fun main() {
    println(splitArray(intArrayOf(7,2,5,10,8), 2))
}
