package arraysandstrings

fun process(a: Int, b: Int, res: MutableList<String>) {
    when {
        b - a == 2 -> res.add((a + 1).toString())
        b - a > 2 -> res.add((a + 1).toString() + "->" + (b - 1).toString())
    }
}

fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {
    val res = mutableListOf<String>()
    var start = lower - 1
    for(n in nums) {
        process(start, n, res)
        start = n
    }
    process(start, upper + 1, res)
    return res
}

fun main() {
    println(findMissingRanges(intArrayOf(0,1,3,50,75), 0, 99).toString())
}
