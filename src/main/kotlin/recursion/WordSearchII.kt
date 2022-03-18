package recursion

class WordSearchII {
    class TrieNode {
        val children = HashMap<Char, TrieNode>()
        var isLeaf = false
    }

    private val ret = mutableSetOf<String>()
    private var board: Array<CharArray> = arrayOf<CharArray>()

    private var m: Int = -1
    private var n: Int = -1
    private var visited: BooleanArray = booleanArrayOf()

    private fun find(i: Int, j: Int, cur: TrieNode, sb: StringBuilder) {
        if (board[i][j] in cur.children) {
            visited[i * n + j] = true
            sb.append(board[i][j])
            val next = cur.children[board[i][j]]!!
            if (next.isLeaf) {
                ret.add(sb.toString())
            }

            if (i > 0 && !visited[(i - 1) * n + j]) find(i - 1, j, next, sb)
            if (i < m - 1 && !visited[(i + 1) * n + j]) find(i + 1, j, next, sb)
            if (j > 0 && !visited[i * n + j - 1]) find(i, j - 1, next, sb)
            if (j < n - 1 && !visited[i * n + j + 1]) find(i, j + 1, next, sb)

            sb.deleteCharAt(sb.lastIndex)
            visited[i * n + j] = false
        }
    }

    // O(m * n * max(word length))
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {

        this.board = board

        val trieRoot = TrieNode()

        for (word in words) {
            var cur = trieRoot
            for (ch in word) {
                if (ch !in cur.children) {
                    cur.children[ch] = TrieNode()
                }
                cur = cur.children[ch]!!
            }
            cur.isLeaf = true
        }

        m = board.size
        n = board[0].size

        for (i in 0 until m) {
            for (j in 0 until n) {
                visited = BooleanArray(m * n) {false}
                val sb = StringBuilder()
                find(i, j, trieRoot, sb)
            }
        }

        return ret.toList()
    }

}

fun main() {
    println(WordSearchII().findWords(arrayOf(
        charArrayOf('a','b','c','e'),
        charArrayOf('x','x','c','d'),
        charArrayOf('x','x','b','a')),
        arrayOf("abc","abcd")))
}
