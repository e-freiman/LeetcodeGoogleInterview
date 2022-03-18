package recursion

val squares: MutableList<MutableList<String>> = mutableListOf()

data class TrieNode(val children: MutableMap<Char, TrieNode>)
val root = TrieNode(mutableMapOf())

fun traverse(square: MutableList<String>, cur: TrieNode, word: StringBuilder, words: Array<String>) {
    if (word.length == words[0].length) {
        square.add(word.toString())
        search(square, words)
        square.removeAt(square.lastIndex)
    }

    for (entry in cur.children.entries) {
        word.append(entry.key)
        traverse(square, entry.value, word, words)
        word.deleteCharAt(word.lastIndex)
    }
}

fun search(square: MutableList<String>, words: Array<String>) {
    val n = square.size

    if (square.size == words[0].length) {
        squares.add(ArrayList(square))
        return
    }

    // following tries for finding the given prefix of n characters
    var cur = root
    val sb = StringBuilder()
    for (i in 0 until n) {
        if (square[i][n] in cur!!.children) {
            sb.append(square[i][n])
            cur = cur.children[square[i][n]]!!
        } else {
            break
        }
    }

    // traversing the rest of the trie since all words fit
    if (sb.length == n) {
        traverse(square, cur, sb, words)
    }
}

//O(m^n)
fun wordSquares(words: Array<String>): List<List<String>> {

    for(word in words) {
        var cur = root
        for (ch in word) {
            if (ch !in cur.children) {
                cur.children[ch] = TrieNode(mutableMapOf())
            }
            cur = cur.children[ch]!!
        }
    }

    search(ArrayList(words[0].length), words)
    return squares
}

fun main() {
    println(wordSquares(arrayOf("area","lead","wall","lady","ball")))
}
