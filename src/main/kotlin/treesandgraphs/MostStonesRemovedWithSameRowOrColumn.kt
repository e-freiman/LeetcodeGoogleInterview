package treesandgraphs

private var xIndex = mapOf<Int, List<Int>>()
private var yIndex = mapOf<Int, List<Int>>()
private var visited = booleanArrayOf()

private fun dfs(stones: Array<IntArray>, index: Int): Int {
    visited[index] = true
    var sum = 0
    for (i in xIndex[stones[index][0]]!!) {
        if (!visited[i]) {
            sum += dfs(stones, i) + 1
        }
    }
    for (i in yIndex[stones[index][1]]!!) {
        if (!visited[i]) {
            sum += dfs(stones, i) + 1
        }
    }
    return sum
}

fun removeStones(stones: Array<IntArray>): Int {
    xIndex = stones.indices.groupBy({stones[it][0]},{it})
    yIndex = stones.indices.groupBy({stones[it][1]},{it})
    visited = BooleanArray(stones.size) { false }
    var stonesToRemove = 0
    for (i in stones.indices) {
        if (!visited[i]) {
            stonesToRemove += dfs(stones, i)
        }
    }
    return stonesToRemove
}

fun main() {
    println(removeStones(arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0),
        intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(2, 2))))
}
