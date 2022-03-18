package sortingandsearching

fun binarySearch(nums: IntArray, target: Double): Int {

    if (target < nums[0]) {
        return -1
    }

    if (target > nums.last()) {
        return nums.lastIndex
    }

    var l = 0
    var r = nums.lastIndex

    while (l < r - 1) {
        val i = (l + r) / 2

        when {
            nums[i] > target -> r = i
            nums[i] < target -> l = i
        }
    }
    return l
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) {
        return intArrayOf(-1, -1)
    }
    var l = binarySearch(nums, target - 0.5) + 1
    var r = binarySearch(nums, target + 0.5)
    return intArrayOf(if (l >= 0 && l < nums.size && nums[l] == target) l else -1,
        if (r >= 0 && r < nums.size && nums[r] == target) r else -1)
}
fun main() {
    println(searchRange(intArrayOf(5,7,7,8,8,10), 8).contentToString())
}
