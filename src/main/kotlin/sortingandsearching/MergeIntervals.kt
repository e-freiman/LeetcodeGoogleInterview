package sortingandsearching

// O(n)
fun merge(intervals: Array<IntArray>): Array<IntArray> {

    intervals.sortWith(object: Comparator<IntArray> {
        override fun compare(a: IntArray, b: IntArray) =
            when {
                a[0] != b[0] -> a[0] - b[0]
                else -> a[1] - b[1]
            }
    })

    val ret = mutableListOf<IntArray>()

    var begin = 0

    while (begin < intervals.lastIndex) {
        var i = begin
        var j = begin + 1
        while (j < intervals.size && intervals[j][0] <= intervals[i][1]) {
            if (intervals[j][1] > intervals[i][1]) {
                i = j
            }
            j++
        }
        ret.add(intArrayOf(intervals[begin][0], intervals[i][1]))
        begin = j
    }

    if (begin == intervals.lastIndex) {
        ret.add(intervals[begin])
    }

    return ret.toTypedArray()
}

fun main() {
    arrayOf(intArrayOf(1,4), intArrayOf(4,5))
}
