package treesandgraphs

import java.util.LinkedList
import java.util.Queue

fun isReachable(a: String, b: String): Boolean {
    assert(a.length == b.length)
    var diff = 0
    for (i in a.indices) {
        if(a[i] != b[i]) diff++
        if (diff > 1) break
    }
    return diff == 1
}

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {

    val depth = Array(wordList.size) {-1}
    val queue: Queue<Int> = LinkedList()
    queue.add(-1)

    while(!queue.isEmpty()) {
        val index = queue.poll()
        val word = if (index == -1) beginWord else wordList[index]
        val currentDepth = if (index == -1) 0 else depth[index]

        if (word == endWord) {
            return currentDepth + 1
        }

        for (i in wordList.indices) {
            if (depth[i] == -1 && isReachable(word, wordList[i])) {
                depth[i] = currentDepth + 1
                queue.add(i)
            }
        }
    }

    return 0
}

fun main() {
    println(ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log","cog")))
}
