package linkedlists

private var visited = booleanArrayOf()
private var cycleDetector = booleanArrayOf()
private var graph = listOf<MutableList<Int>>()

private val ret = mutableListOf<Int>()

fun dfs(vertex: Int): Boolean {
    cycleDetector[vertex] = true
    var noCycle = true

    for (prereq in graph[vertex]) {
        if (!visited[prereq]) {
            if (cycleDetector[prereq]) {
                return false
            }
            noCycle = noCycle && dfs(prereq)
        }
    }
    ret.add(vertex)
    visited[vertex] = true
    cycleDetector[vertex] = false
    return noCycle
}

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    visited = BooleanArray(numCourses) {false}
    cycleDetector = BooleanArray(numCourses) {false}
    graph = MutableList<MutableList<Int>>(numCourses) {mutableListOf<Int>()}

    for (edge in prerequisites) {
        graph[edge[0]].add(edge[1])
    }

    for (vertex in visited.indices) {
        if (!visited[vertex]) {
            if (!dfs(vertex)) {
                return intArrayOf()
            }
        }
    }

    return ret.toIntArray()
}

fun main() {
    println(findOrder(2, arrayOf(intArrayOf(1, 0))).contentToString())
}
