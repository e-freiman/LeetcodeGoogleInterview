package arraysandstrings

fun maxDistToClosest(seats: IntArray): Int {
    var maxDistance = 0
    var count = 0
    var started = false
    for (i in seats.indices) {
        if (seats[i] == 1) {
            val distance = if (started) (count - 1) / 2 + 1 else count
            maxDistance = maxOf(distance, maxDistance)
            started = true
            count = 0
        } else {
            count++
        }
    }
    if (seats.last() == 0) {
        maxDistance = maxOf(count, maxDistance)
    }

    return maxDistance
}


fun main() {
    println(maxDistToClosest(intArrayOf(1, 0, 0, 0, 0, 1)))
}
