package sortingandsearching

// O(log(min(m, n)))
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val a = if (nums1.size < nums2.size) nums1 else nums2
    val b = if (nums1.size < nums2.size) nums2 else nums1

    var l = 0
    var r = a.size
    var i: Int
    var j: Int
    var found: Boolean
    do {
        i = (l + r) / 2
        j = (a.size + b.size) / 2 - i
        found = true

        if (i > 0 && i <= a.size && j >= 0 && j < b.size && a[i - 1] > b[j]) {
            r = i - 1
            found = false
        }

        if (i >= 0 && i < a.size && j > 0 && j <= b.size && b[j - 1] > a[i]) {
            l = i + 1
            found = false
        }
    } while (!found)

    val left = maxOf(
        if (i > 0 && i <= a.size) a[i - 1] else Int.MIN_VALUE,
        if (j > 0 && j <= b.size) b[j - 1] else Int.MIN_VALUE)

    val right =  minOf(
        if (i >= 0 && i < a.size) a[i] else Int.MAX_VALUE,
        if (j >= 0 && j < b.size) b[j] else Int.MAX_VALUE)

    return if ((a.size + b.size) % 2 == 0)
        (left + right) / 2.0
    else
        right / 1.0
}


fun main() {
    println(findMedianSortedArrays(intArrayOf(2,3,4,5,6,7), intArrayOf(1)))
}
