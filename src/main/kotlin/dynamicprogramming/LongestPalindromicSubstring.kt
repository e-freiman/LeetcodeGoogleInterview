package dynamicprogramming

private var memo: Array<Array<Boolean?>>? = null

fun isPalindrome(s: String, i: Int, j: Int): Boolean {
    if (memo!![i][j] != null) {
        return memo!![i][j]!!
    }
    if (i == j) {
        memo!![i][j] = true
        return true
    }
    if (i == j - 1) {
        memo!![i][j] = s[i] == s[j]
        return s[i] == s[j]
    }

    val res = s[i] == s[j] && isPalindrome(s, i + 1, j - 1)
    memo!![i][j] = res
    return res
}

// O(N^2)
fun longestPalindrome(s: String): String {
    memo = Array(s.length) {Array<Boolean?>(s.length) {null} }

    var ti = s.lastIndex
    var tj = 0

    for (i in s.indices) {
        for (j in i..s.lastIndex) {
            if (isPalindrome(s, i, j) && j - i > tj - ti) {
                ti = i
                tj = j
            }
        }
    }

    return s.substring(ti, tj + 1)
}

fun main() {
    println(longestPalindrome("ac"))
}
