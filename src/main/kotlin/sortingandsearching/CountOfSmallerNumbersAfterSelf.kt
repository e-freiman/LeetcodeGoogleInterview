package sortingandsearching

private const val OFFSET = 10000
private const val SIZE = 2 * 10000 + 1

private val segmentTree = IntArray(4 * SIZE) { 0 }

private fun update(vertex: Int, left: Int, right: Int, pos: Int, value: Int) {
    if (left == right) {
        segmentTree[vertex] += value
        return
    }
    val middle = (left + right) / 2
    if (pos <= middle) {
        update(2 * vertex, left, middle, pos, value)
    } else {
        update(2 * vertex + 1,middle + 1, right, pos, value)
    }
    segmentTree[vertex] = segmentTree[2 * vertex] + segmentTree[2 * vertex + 1]
}

private fun query(vertex: Int, left: Int, right: Int, queryLeft: Int, queryRight: Int): Int {
    if (left == queryLeft && right == queryRight) {
        return segmentTree[vertex]
    }
    val middle = (left + right) / 2
    return when {
        queryRight <= middle -> query(2 * vertex, left, middle, queryLeft, queryRight)
        queryLeft > middle -> query(2 * vertex + 1, middle + 1, right, queryLeft, queryRight)
        else -> query(2 * vertex, left, middle, queryLeft, middle) +
                query(2 * vertex + 1, middle + 1, right, middle + 1, queryRight)
    }
}

// O(N*logN)
private fun countSmaller(nums: IntArray): List<Int> {
    val ret = mutableListOf<Int>()
    // O(N * logN)
    for (num in nums.reversed()) {
        // O(logN)
        update(1, 0, SIZE, num + OFFSET, 1)
        // O(logN)
        ret.add(query(1, 0, SIZE, 0, num + OFFSET - 1))
    }
    return ret.reversed()
}

fun main() {
    println(countSmaller(intArrayOf(5,2,6,1)))
}
