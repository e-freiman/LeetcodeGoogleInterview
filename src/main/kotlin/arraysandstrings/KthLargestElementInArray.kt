package arraysandstrings

import java.util.PriorityQueue

fun findKthLargest(nums: IntArray, k: Int): Int {
    val pq = PriorityQueue<Int>()

    for (n in nums) {
        pq.add(n)
        if (pq.size > k) {
            pq.poll()
        }
    }

    return pq.poll()
}

fun main() {
    println(findKthLargest(intArrayOf(3,2,1,5,6,4), k = 2))
}
