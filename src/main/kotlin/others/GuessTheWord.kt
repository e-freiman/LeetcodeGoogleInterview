package others

import java.util.Random

private interface Master {
    fun guess(word: String): Int
}

private fun String.similar(s: String) = this.indices.count {this[it] == s[it]}

private fun findSecretWord(wordlist: Array<String>, master: Master) {
    val words = wordlist.toMutableList()
    var res = 0

    do {
        val target = words[Random().nextInt(words.size)]
        res = master.guess(target)
        if (res == 6) {
            break
        }

        words.remove(target)

        val iter = words.iterator()
        while (iter.hasNext()) {
            val s = iter.next()
            val similarity = s.similar(target)
            if (similarity != res) {
                iter.remove()
            }
        }
    } while (true)
}

class MasterImpl: Master {
    override fun guess(word: String): Int {
        //For testing
        return 3
    }
}

fun main() {
    findSecretWord(wordlist = arrayOf("acckzz","ccbazz","eiowzz","abcczz"), MasterImpl())
}
