package arraysandstrings

fun isValid(arr: IntArray): Boolean {
    var hour = arr[0] * 10 + arr[1]
    var minute = arr[2] * 10 + arr[3]
    return hour < 24 && minute < 60
}

fun totalMinutes(arr: IntArray): Int {
    var hour = arr[0] * 10 + arr[1]
    var minute = arr[2] * 10 + arr[3]
    return  hour * 60 + minute
}

fun diff(minutes1: Int, minutes2: Int): Int {
    return when {
            minutes2 > minutes1 -> minutes2 - minutes1
            minutes2 > minutes1 -> 60*24 - minutes1 + minutes2
        else -> 60*24
    }
}

var base: Int = 0
var baseArr: IntArray = intArrayOf()
var minDiff = 60*24 + 1
var res: IntArray = intArrayOf()

fun Char.digitToInt() = this.toInt() - '0'.toInt()

fun traverse(arr: IntArray, start: Int) {
    if (start > arr.lastIndex) {
        if (isValid(arr)) {
            val curDiff = diff(base, totalMinutes(arr))
            if (curDiff in 1 until minDiff) {
                minDiff = curDiff
                res = arr
            }
            //println(arr.contentToString())
        }
        return
    }

    for (j in baseArr.indices) {
        val newArr = arr.clone()
        newArr[start] = baseArr[j]
        traverse(newArr, start + 1)
    }
}

fun nextClosestTime(time: String): String {
    val arr = intArrayOf(
        time[0].digitToInt(),
        time[1].digitToInt(),
        time[3].digitToInt(),
        time[4].digitToInt())

    base = totalMinutes(arr)
    baseArr = arr.clone()
    traverse(arr, 0)
    return "${res[0]}${res[1]}:${res[2]}${res[3]}"
}

fun main() {
    println(nextClosestTime("19:34"))
}
