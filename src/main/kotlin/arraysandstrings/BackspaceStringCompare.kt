package arraysandstrings

fun backspaceCompare(s: String, t: String): Boolean {
    var i = s.lastIndex
    var j = t.lastIndex
    var sBackspaces = 0
    var tBackspaces = 0

    while (i >= 0 || j >= 0) {
        while (i >= 0 && (sBackspaces > 0 || s[i] == '#')) {
            if (s[i--] == '#') {
                sBackspaces++
            } else {
                sBackspaces--
            }
        }
        while (j >= 0 && (tBackspaces > 0 || t[j] == '#')) {
            if (t[j--] == '#') {
                tBackspaces++
            } else {
                tBackspaces--
            }
        }

        if (i < 0 && j < 0) {
            return true
        }

        if (i < 0 || j < 0 || s[i--] != t[j--]) {
            return false
        }
    }
    return true
}

fun main() {
    println(backspaceCompare("ab#c", "ad#c"))
}

