package dynamicprogramming

fun maxSubArray(nums: IntArray): Int {

    var maxSum = Int.MIN_VALUE
    var sum = 0

    for (n in nums) {
        sum += n
        maxSum = maxOf(sum, maxSum)
        if (sum < 0) {
            sum = 0
        }
    }

    return maxSum
}

fun main() {
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
}
