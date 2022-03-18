package sortingandsearching

private val sChars = mutableMapOf<Char, Int>()

private fun isAnagram(s: String, t: String): Boolean {
    for (sChar in s) {
        sChars[sChar] = (sChars[sChar] ?: 0) + 1
    }

    for (tChar in t) {
        val counter = sChars[tChar] ?: return false
        if (counter == 1) {
            sChars.remove(tChar)
        } else {
            sChars[tChar] = counter - 1
        }
    }

    return sChars.isEmpty()
}

fun main() {
    println(isAnagram("anagram", "nagaram"))
}
