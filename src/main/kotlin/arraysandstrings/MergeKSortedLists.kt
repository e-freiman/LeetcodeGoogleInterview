package arraysandstrings

import java.util.PriorityQueue

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var pq = PriorityQueue<ListNode>(compareBy {it.`val`})
    lists.filterNotNull().forEach {pq.add(it)}

    var root: ListNode? = null
    var cur: ListNode? = null

    while (!pq.isEmpty()) {
        val node = pq.poll()

        if (root == null) {
            root = node
            cur = node
        } else {
            cur!!.next = node
            cur = cur!!.next
        }

        if (node.next != null) {
            pq.add(node.next)
        }
    }

    return root
}
