package arraysandstrings

import java.util.PriorityQueue

// O(n*log(n))
fun minMeetingRooms(intervals: Array<IntArray>): Int {
    intervals.sortWith(object: Comparator<IntArray> {
        override fun compare(a: IntArray, b: IntArray) =
            when {
                a[0] != b[0] -> a[0] - b[0]
                else -> a[1] - b[1]
            }

    })

    val rooms = PriorityQueue<Int>()

    for (i in intervals.indices) {
        val room = rooms.peek()
        if (room != null && room <= intervals[i][0]) {
            rooms.poll()
        }
        rooms.add(intervals[i][1])
    }

    return rooms.size
}

fun main() {
    println(minMeetingRooms(arrayOf(intArrayOf(7, 10), intArrayOf(2, 4))))
}

