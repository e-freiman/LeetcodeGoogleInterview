package arraysandstrings

// O(n)
fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
    val window = mutableMapOf<Char, Int>()
    var start = 0
    var max = 0

    for(i in s.indices) {
        if (window.size < 2 || s[i] in window) {
            window[s[i]] = i
        }  else {
            val toRemove = if (window.keys.first() == s[i - 1])
                window.keys.last() else window.keys.first()
            start = window[toRemove]!! + 1
            window.remove(toRemove)
            window[s[i]] = i
        }

        max = maxOf(max, i - start + 1)
    }

    return max
}

fun main() {
    println(lengthOfLongestSubstringTwoDistinct("ccaabbb"))
}
