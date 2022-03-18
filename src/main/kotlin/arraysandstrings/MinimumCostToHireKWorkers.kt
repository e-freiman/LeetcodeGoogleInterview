package arraysandstrings

import java.util.PriorityQueue

fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
    val x = wage.indices.sortedWith {a, b ->
            val ra = wage[a].toDouble() / quality[a].toDouble()
            val rb = wage[b].toDouble() / quality[b].toDouble()
            if (ra < rb) -1 else 1
        }

    val pq = PriorityQueue<Int>(k) {a, b -> b - a}

    var minGroupPay = Double.MAX_VALUE
    var sum = 0

    for (i in x.indices) {
        val cost = wage[x[i]].toDouble() / quality[x[i]].toDouble()
        pq.add(quality[x[i]])
        sum += quality[x[i]]
        if (pq.size > k) {
            sum -= pq.poll()
        }
        if (pq.size == k) {
            minGroupPay = minOf(sum.toDouble() * cost, minGroupPay)
        }
    }
    return minGroupPay
}

fun main() {
    println(mincostToHireWorkers(intArrayOf(10,20,5), intArrayOf(70,50,30), 2))
}
