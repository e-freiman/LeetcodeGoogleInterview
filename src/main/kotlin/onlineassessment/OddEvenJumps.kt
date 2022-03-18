package onlineassessment

import java.util.TreeMap
import java.util.TreeSet

class OddEvenJumps {

    private lateinit var memo: Array<Array<Boolean?>>
    private lateinit var map: TreeMap<Int, TreeSet<Int>>

    private fun jump(number: Int, i: Int, isOdd: Boolean): Int? {
        var numberIter = if (isOdd) {
            map.tailMap(number).keys.iterator()
        } else {
            map.descendingMap().tailMap(number).keys.iterator()
        }
        while (numberIter.hasNext()) {
            val nextNumber = numberIter.next()
            var indexIter = map[nextNumber]!!.tailSet(i + 1).iterator()
            while (indexIter.hasNext()) {
                return indexIter.next()
            }
        }
        return null
    }

    fun oddEvenJumps(arr: IntArray): Int {

        map = TreeMap()

        for (i in arr.indices) {
            if (!map.containsKey(arr[i])) {
                map[arr[i]] = TreeSet()
            }
            map[arr[i]]!!.add(i)
        }

        memo = arrayOf(Array(arr.size) {null as Boolean?}, Array(arr.size) {null as Boolean?})
        memo[0][arr.size - 1] = true
        memo[1][arr.size - 1] = true

        var count = 1
        for (i in arr.size - 2 downTo 0) {
            for (k in 0 until 2) {
                val next = jump(arr[i], i, k == 0)
                if (next != null && memo[(k + 1) % 2][next] != null) {
                    memo[k][i] = true
                    if (k == 0) {
                        count++
                    }
                }
            }
        }
        return count
    }
}

fun main() {
    val arr = intArrayOf(2,3,1,1,4)
    println(OddEvenJumps().oddEvenJumps(arr))
}

