package others

fun candy(ratings: IntArray): Int {

    val output = IntArray(ratings.size){1}

    for (i in 1..ratings.lastIndex) {
        if (ratings[i - 1] < ratings[i]) {
            output[i] = output[i - 1] + 1
        }
    }

    for (i in output.lastIndex - 1 downTo 0) {
        if (ratings[i] > ratings[i + 1] && output[i] <= output[i + 1]) {
            output[i] = output[i + 1] + 1
        }
    }
    return output.sum()
}

fun main() {
    println(candy(intArrayOf(1,0,2)))
}
