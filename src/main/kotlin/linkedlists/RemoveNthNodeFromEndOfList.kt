package linkedlists

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var first = head

    for (i in 1..n) {
        first = first!!.next
    }

    if (first == null) {
        return head!!.next
    }

    var prevSecond: ListNode? = null
    var second = head
    while (first != null) {
        first = first.next
        prevSecond = second
        second = second!!.next
    }

    prevSecond!!.next = second!!.next

    return head
}
