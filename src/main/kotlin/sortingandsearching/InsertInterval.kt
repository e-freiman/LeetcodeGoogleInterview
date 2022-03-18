package sortingandsearching

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

    val ret = mutableListOf<IntArray>()

    var a = newInterval[0]
    var b = newInterval[1]

    var mergeHappened = false

    for (interval in intervals) {

        // new interval before current
        if (b < interval[0]) {
            if (!mergeHappened) {
                ret.add(intArrayOf(a, b))
                mergeHappened = true
            }
            ret.add(interval)
            continue
        }

        // new interval after current
        if (a > interval[1]) {
            ret.add(interval)
            continue
        }

        // merge
        a = minOf(a, interval[0])
        b = maxOf(b, interval[1])
    }

    if (!mergeHappened) {
        ret.add(intArrayOf(a, b))
    }
    return ret.toTypedArray()
}

fun main() {
    println(insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5)).contentDeepToString())
}
