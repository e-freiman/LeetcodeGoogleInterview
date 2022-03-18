package treesandgraphs

private val sb = StringBuilder()
private val visited = mutableSetOf<String>()

private fun dfs(n: Int, k: Int, v: Int): Boolean {
    val totalV: Int = Math.pow(k.toDouble(), n.toDouble()).toInt()

    if (v == totalV) {
        return true
    }
    val prefix = sb.substring(sb.length - n + 1, sb.length)

    for (i in 0 until k) {
        val password = prefix + i.toString()

        if (password !in visited) {
            visited.add(password)
            sb.append(i.toString())
            if (dfs(n, k, v + 1)) {
                return true
            }
            sb.deleteCharAt(sb.lastIndex)
            visited.remove(password)
        }
    }

    return false
}

fun crackSafe(n: Int, k: Int): String {
    for (i in 0 until n) {
        sb.append("0")
    }
    visited.add(sb.toString())
    dfs(n, k, 1)
    return sb.toString()
}

fun main() {
    println(crackSafe(3, 6))
}
