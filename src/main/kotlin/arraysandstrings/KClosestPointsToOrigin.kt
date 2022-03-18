package arraysandstrings

import java.util.PriorityQueue

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val pq = PriorityQueue<IntArray> {a, b -> -a[0]*a[0] - a[1]*a[1] + b[0]*b[0] + b[1]*b[1] }

    for (point in points) {
        pq.add(point)
        if (pq.size > k) {
            pq.poll()
        }
    }

    return pq.toTypedArray()
}

fun main() {
    println(kClosest(arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2)),1).contentDeepToString())
}
