package arraysandstrings

fun jump(s: String, i: Int): Int {
    for (j in i + 1..s.lastIndex) {
        if (s[i] != s[j]) {
            return j
        }
    }
    return s.lastIndex + 1
}

fun isStretchy(source: String, target: String) : Boolean {
    var i = 0
    var j = 0

    while (i < source.length && j < target.length) {
        if (source[i] == target[j]) {
            val i1 = jump(source, i)
            val sourceSize = i1 - i
            val j1 = jump(target, j)
            val targetSize = j1 - j
            if (targetSize < sourceSize) {
                return false
            }
            if (targetSize < 3 && targetSize != sourceSize) {
                return false
            }
            i = i1
            j = j1
        } else {
            return false
        }
    }
    return i == source.lastIndex + 1 && j == target.lastIndex + 1
}

fun expressiveWords(s: String, words: Array<String>) = words.count { isStretchy(it, s) }

fun main() {
    println(expressiveWords("heeellooo", arrayOf("hello","hi","helo")))
}
