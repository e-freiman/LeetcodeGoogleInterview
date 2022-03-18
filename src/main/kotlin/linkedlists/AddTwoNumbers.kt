package linkedlists

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var ll1 = l1
    var ll2 = l2

    var overflow = 0
    var root: ListNode? = null
    var cur: ListNode? = null

    while (ll1 != null || ll2 != null || overflow > 0) {
        var v = overflow
        if (ll1 != null) v += ll1.`val`
        if (ll2 != null) v += ll2.`val`
        val node = ListNode(v % 10)
        overflow = v / 10

        if (root == null) {
            root = node
            cur = node
        } else {
            cur!!.next = node
            cur = cur!!.next
        }

        if (ll1 != null) ll1 = ll1.next
        if (ll2 != null) ll2 = ll2.next

        if (overflow == 0 && ll1 == null) {
            cur!!.next = ll2
            break
        }

        if (overflow == 0 && ll2 == null) {
            cur!!.next = ll1
            break
        }
    }

    return root
}
