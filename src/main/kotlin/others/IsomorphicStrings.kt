package others

fun isIsomorphic(s: String, t: String): Boolean {

    val map = mutableMapOf<Char, Char>()
    val rightSide = mutableSetOf<Char>()

    for (i in s.indices) {
        if (s[i] in map) {
            if (t[i] != map[s[i]]) {
                return false
            }
        } else {
            if (t[i] in rightSide) {
                return false
            }
            map[s[i]] = t[i]
            rightSide.add(t[i])
        }
    }

    return true

}

fun main() {
    println(isIsomorphic("egg", "add"))
}
