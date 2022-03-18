package others

class MyCalendarTwo() {

    private val booked = sortedMapOf<Int, MutableList<Pair<Int, Int>>>()
    private val doubleBooked = sortedMapOf<Int, MutableList<Pair<Int, Int>>>()

    // O(N)
    fun book(start: Int, end: Int): Boolean {
        // Check against double booked
        // DoubleIntervals whose start is before requested interval end
        val doubleIntervals = doubleBooked.headMap(end)
        for (doubleInterval in doubleIntervals.values.flatten()) {
            if (doubleInterval.second > start) {
                return false
            }
        }

        // Updating doubleBooked
        // Intervals whose start is before requested interval end
        val intervals = booked.headMap(end)

        for (interval in intervals.values.flatten()) {
            // filtering out intervals whose end is before requested interval start
            if (interval.second > start) {
                val doubleStart = maxOf(start, interval.first)
                val doubleEnd = minOf(end, interval.second)
                if (doubleStart !in doubleBooked) doubleBooked[doubleStart] = mutableListOf()
                doubleBooked[doubleStart]!!.add(doubleStart to doubleEnd)
            }
        }

        // Updating booked
        if (start !in booked) booked[start] = mutableListOf()
        booked[start]!!.add(start to end)
        return true
    }
}

fun main() {
    val myCalendarTwo = MyCalendarTwo()
    println(myCalendarTwo.book(10, 20)) // return True, The event can be booked.
    println(myCalendarTwo.book(50, 60)) // return True, The event can be booked.
    println(myCalendarTwo.book(10, 40)) // return True, The event can be double booked.
    println(myCalendarTwo.book(5, 15)) // return False, The event cannot be booked, because it would result in a triple booking.
    println(myCalendarTwo.book(5, 10)) // return True, The event can be booked, as it does not use time 10 which is already double booked.
    println(myCalendarTwo.book(25, 55)) // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event
}
