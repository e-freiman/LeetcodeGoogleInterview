package arraysandstrings

import java.util.SortedSet

// Given m==n, O(n*log(n))
fun minWindow(s: String, t: String): String {
    var smap = mutableMapOf<Char, SortedSet<Int>>()

    // O(n*log(n))
    for (tc in t) {
        if (tc !in smap) {
            smap[tc] = sortedSetOf()
        }
    }

    // O(m*log(n))
    for (i in s.indices) {
        if (s[i] in smap) {
            smap[s[i]]!!.add(i)
        }
    }

    // Creating initial window
    // O(n*log(n))
    var window = sortedMapOf<Int, Char>()
    for (tc in t) {
        val index = smap[tc]!!.firstOrNull() ?: return ""
        smap[tc]!!.remove(index)
        window[index] = tc
    }

    // O(log(n)
    var begin = window.firstKey()
    var end = window.lastKey()

    //Moving the window
    //O(m*log(n))
    while (true) {
        val wEntry = window.entries.first()
        val index = smap[wEntry.value]!!.firstOrNull() ?: break
        smap[wEntry.value]!!.remove(index)

        window.remove(wEntry.key)
        window[index] = wEntry.value

        if (window.lastKey() - window.firstKey() < end - begin) {
            begin = window.firstKey()
            end = window.lastKey()
        }
    }
    return s.substring(begin, end + 1)
}

fun main() {
    println(minWindow(s = "ADOBECODEBANC", t = "ABC"))
}
