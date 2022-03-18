package dynamicprogramming

fun processSubarray(a: Int, b: Int, negatives: Int, nums: IntArray): Int {
    if (a > b) {
        return 0
    }
    if (a == b) {
        return nums[a]
    }

    var i = a
    var j = b
    var leftProd = 1
    var rightProd = 1

    if (negatives % 2 == 1) {
        while (nums[i] > 0) {
            leftProd *= nums[i]
            i++
        }
        while (nums[j] > 0) {
            rightProd *= nums[j]
            j--
        }

        if (i == j) {
            return maxOf(leftProd, rightProd)
        }

        return if (-leftProd * nums[i] > -rightProd * nums[j]) {
            for (k in i..j - 1) {
                leftProd *= nums[k]
            }
            leftProd
        } else {
            for (k in j downTo i + 1) {
                rightProd *= nums[k]
            }
            rightProd
        }
    } else {
        var prod = 1
        for (k in a..b) {
            prod *= nums[k]
        }
        return prod
    }
}

fun maxProduct(nums: IntArray): Int {

    var maxProd = Int.MIN_VALUE

    var begin = 0
    var negatives = 0
    for (i in nums.indices) {
        if (nums[i] < 0) {
            negatives++
        }
        if (nums[i] == 0) {
            val prod = processSubarray(begin, i - 1, negatives, nums)
            maxProd = maxOf(prod, maxProd, 0)
            negatives = 0
            begin = i + 1
        }
    }

    val prod = processSubarray(begin, nums.lastIndex, negatives, nums)
    maxProd = maxOf(prod, maxProd)

    return maxProd
}


fun main() {
    println(maxProduct(intArrayOf(2,3,-2,4)))
}
