package design

class AutocompleteSystem(sentences: Array<String>, times: IntArray) {

    private class TrieNode {
        var leafTimes = 0
        val children = mutableMapOf<Char, TrieNode>()
    }

    private val trieRoot = TrieNode()
    private var currentNode: TrieNode
    private val prefix = StringBuilder()

    init {
        for (i in sentences.indices) {
            var cur = trieRoot
            for (c in sentences[i]) {
                if (c !in cur.children) {
                    cur.children[c] = TrieNode()
                }
                cur = cur.children[c]!!
            }
            cur.leafTimes = times[i]
        }
        currentNode = trieRoot
    }

    private fun dfsTraverse(prefix: StringBuilder, currentNode: TrieNode, sentencesList: MutableList<Pair<String, Int>>) {

        if (currentNode.leafTimes > 0) {
            sentencesList.add(prefix.toString() to currentNode.leafTimes)
        }

        for (entry in currentNode.children.entries.iterator()) {
            prefix.append(entry.key)
            dfsTraverse(prefix, entry.value, sentencesList)
            prefix.deleteCharAt(prefix.lastIndex)
        }
    }

    fun input(c: Char): List<String> {
        if (c == '#') {
            currentNode.leafTimes++
            currentNode = trieRoot
            prefix.delete(0, prefix.length)
            return listOf<String>()
        }

        if (c !in currentNode.children) {
            currentNode.children[c] = TrieNode()
        }

        currentNode = currentNode.children[c]!!
        prefix.append(c)
        val sentencesList = mutableListOf<Pair<String, Int>>()
        dfsTraverse(prefix, currentNode, sentencesList)

        sentencesList.sortWith(object: Comparator<Pair<String, Int>> {
            override fun compare(a: Pair<String, Int>, b: Pair<String, Int>): Int = when {
                a.second != b.second -> -a.second + b.second
                else -> a.first.compareTo(b.first)
            }
        })

        return if (sentencesList.size < 3) {
            sentencesList.map {it.first}
        } else {
            sentencesList.subList(0, 3).map {it.first}
        }
    }

}

fun main() {
    val obj = AutocompleteSystem(arrayOf("i love you", "island", "iroman", "i love leetcode"), intArrayOf(5, 3, 2, 2))
    println(obj.input('i')) // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
    println(obj.input(' ')) // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
    println(obj.input('a')) // return []. There are no sentences that have prefix "i a".
    println(obj.input('#')) // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
}
