package recursion

private val ret = mutableListOf<String>()

private fun next(sb: StringBuilder, m: Int, counter: Int) {
    if (sb.length == m) {
        if (counter == 0) ret.add(sb.toString())
        return
    }

    sb.append('(')
    next(sb, m, counter + 1)
    sb.deleteCharAt(sb.lastIndex)

    if (counter > 0) {
        sb.append(')')
        next(sb, m, counter - 1)
        sb.deleteCharAt(sb.lastIndex)
    }
}

fun generateParenthesis(n: Int): List<String> {
    next(StringBuilder(), 2*n, 0)
    return ret
}
