package arraysandstrings

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        val substring = mutableMapOf<Char, Int>()
        var max = 0
        var start = 0
        for (i in s.indices) {
            if (s[i] in substring) {
                val end = substring[s[i]]!!
                for (j in start..end) {
                    substring.remove(s[j])
                }
                start = end + 1

            }
            substring[s[i]] = i
            max = maxOf(substring.size, max)
        }
        return max
    }
}

fun main() {
    println(LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("umvejcuuk"))
}

