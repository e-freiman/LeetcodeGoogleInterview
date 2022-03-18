package treesandgraphs

private data class Vertex(val name: String, val edges: MutableList<Pair<Vertex, Double>>) {
    var visited = false
}

class EvaluateDivision {
    private val vertexes = mutableMapOf<String, Vertex>()

    private fun dfs(v: Vertex, target: Vertex, value: Double): Pair<Boolean, Double> {
        v.visited = true
        if (v === target) {
            return true to value
        }
        for (e in v.edges) {
            if (!e.first.visited) {
                val r = dfs(e.first, target, value * e.second)
                if (r.first) {
                    return r
                }
            }
        }
        return false to -1.0
    }

    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        for (i in equations.indices) {
            val v1 = vertexes[equations[i][0]] ?: Vertex(equations[i][0], mutableListOf())
            val v2 = vertexes[equations[i][1]] ?: Vertex(equations[i][1], mutableListOf())
            v1.edges.add(v2 to values[i])
            v2.edges.add(v1 to 1.0 / values[i])

            vertexes[v1.name] = v1
            vertexes[v2.name] = v2
        }

        val ret = DoubleArray(queries.size) { -1.0 }
        for ((i, q) in queries.withIndex()) {
            var v1 = vertexes[q[0]]
            var v2 = vertexes[q[1]]

            if (v1 != null && v2 != null) {
                for (entry in vertexes.entries) {
                    entry.value.visited = false
                }
                ret[i] = dfs(v1, v2, 1.0).second
            }
        }
        return ret
    }
}
