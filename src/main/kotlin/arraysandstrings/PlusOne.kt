package arraysandstrings

fun plusOne(digits: IntArray): IntArray {
    var overflow = 1
    for (i in digits.lastIndex downTo 0) {
        val v = digits[i] + overflow
        digits[i] = v % 10
        overflow = v / 10
    }
    return if (overflow > 0) {
        IntArray(digits.size + 1) {
            if (it == 0) overflow else digits[it - 1]
        }
    } else {
        digits
    }
}

fun main() {
    println(plusOne(intArrayOf(9,9,9)).contentToString())
}
