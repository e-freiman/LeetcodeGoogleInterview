package arraysandstrings

data class Item(val index: Int, val source: String, val target: String)

fun findReplaceString(s: String, indices: IntArray, sources: Array<String>, targets: Array<String>): String {

    if (indices.isEmpty()) {
        return s
    }

    val items = Array(indices.size) { Item(indices[it], sources[it], targets[it]) }
    items.sortBy { it.index }

    val sb = StringBuilder()
    sb.append(s.substring(0, items[0].index))

    for(i in items.indices) {
        var shift = 0
        if (s.substring(items[i].index, items[i].index + items[i].source.length) == items[i].source) {
            sb.append(items[i].target)
            shift = items[i].source.length
        }

        if (i < items.lastIndex) {
            sb.append(s.substring(items[i].index + shift, items[i + 1].index))
        } else {
            sb.append(s.substring(items[i].index + shift))
        }
    }

    return sb.toString()
}

fun main() {
    println(findReplaceString("vmokgggqzp", intArrayOf(3,5,1), arrayOf("kg","ggq","mo"), arrayOf("s","so","bfr")))
}
