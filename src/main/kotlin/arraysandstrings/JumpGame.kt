package arraysandstrings

fun canJump(nums: IntArray): Boolean {
    var res = true
    var zeroIndex = -1
    for (i in nums.lastIndex - 1 downTo 0) {
        if (res && nums[i] == 0) {
            res = false
            zeroIndex = i
        }
        if (nums[i] > zeroIndex - i) {
            res = true
        }
    }
    return res
}

fun main() {
    println(canJump(intArrayOf(2,0,1,0,1)))
}
