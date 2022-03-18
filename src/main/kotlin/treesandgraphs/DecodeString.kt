package treesandgraphs

private val sb = StringBuilder()

private fun parse(s: String) {

    var brakets = 0
    var begin = -1

    for (i in s.indices) {
        if (s[i] == '[') {
            if (brakets == 0) begin = i
            brakets++
            continue
        }
        if (s[i] == ']') {
            if (brakets == 1) {
                var k = begin - 1
                while (k >= 0 && s[k].isDigit()) k--
                val number = s.substring(k + 1, begin).toInt()
                for (j in 0 until number)
                    parse(s.substring(begin + 1, i))
            }
            brakets--
            continue
        }
        if (brakets == 0 && !s[i].isDigit()) {
            sb.append(s[i])
        }
    }
}

fun decodeString(s: String): String {
    parse(s)
    return sb.toString()
}

fun main() {
    println(decodeString("3[a]2[bc]"))
}
