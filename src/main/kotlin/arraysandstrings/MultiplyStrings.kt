package arraysandstrings

class MultiplyStrings {

    private fun Char.d(): Int = this - '0'

    private operator fun String.times(digit: Char): String {
        if (digit == '0'|| this == "0") {
            return "0"
        }

        val sb = StringBuilder()

        var overflow = 0
        for (i in this.lastIndex downTo 0) {
            val v = this[i].d() * digit.d()
            sb.insert(0, (v + overflow) % 10)
            overflow = (v + overflow) / 10
        }
        if (overflow != 0) {
            sb.insert(0, overflow)
        }
        return sb.toString()
    }

    private fun String.plus(other: String, shift: Int) : String {
        if (other == "0") {
            return this
        }
        val sb = StringBuilder()
        var overflow = 0
        var j = other.lastIndex
        // cycle through first number
        for (i in this.lastIndex downTo 0) {
            if (i > this.lastIndex - shift || j < 0) {
                //iterations through shift
                sb.insert(0, this[i].d() + overflow)
                overflow = 0
            } else {
                //iterations where digits from both nums placed
                val v = this[i].d() + other[j].d()
                sb.insert(0, (v + overflow) % 10)
                overflow = (v + overflow) / 10
                j--
            }
        }
        // if shift is larger than first number, we need to add 0s
        for (k in this.length until shift) {
            sb.insert(0, overflow)
            overflow = 0
        }
        // if second number + sift is larger than first number
        for (k in j downTo 0) {
            val v = other[k].d() + overflow
            sb.insert(0, v % 10)
            overflow = v / 10
        }
        // if there is leading overflow
        if (overflow != 0) {
            sb.insert(0, overflow)
        }
        return sb.toString()
    }

    // O(N^2)
    fun multiply(num1: String, num2: String): String {
        var sum = "0"
        for (i in num2.indices.reversed()) {
            // O(N)
            val tmp = num1 * num2[i]
            // O(N)
            sum = sum.plus(tmp, num2.lastIndex - i)
        }
        return sum
    }
}

fun main() {
    println(MultiplyStrings().multiply("140", "721"))
}


