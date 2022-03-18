package recursion

class LetterCombinationsOfPhoneNumber {
    private val map = mapOf<Char, String>(
        '2' to "abc", '3' to "def",
        '4' to "ghi", '5' to "jkl", '6' to "mno",
        '7' to "pqrs", '8' to "tuv", '9' to "wxyz"
    )

    private val ret = mutableListOf<String>()

    private fun traverse(digits: String, i: Int, sb: StringBuilder) {
        if (i == digits.length) {
            if (!sb.isEmpty()) {
                ret.add(sb.toString())
            }
            return
        }

        for (c in map[digits[i]]!!) {
            sb.append(c)
            traverse(digits, i + 1, sb)
            sb.deleteCharAt(sb.lastIndex)
        }
    }

    fun letterCombinations(digits: String): List<String> {
        traverse(digits, 0, StringBuilder())
        return ret
    }
}

fun main() {
    println(LetterCombinationsOfPhoneNumber().letterCombinations("23"))
}
