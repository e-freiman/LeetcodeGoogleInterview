package linkedlists

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var cur1 = list1
    var cur2 = list2
    var cur3: ListNode? = null
    var root: ListNode? = null

    while (cur1 != null && cur2 != null) {
        var next: ListNode? = null
        if (cur1.`val` < cur2.`val`) {
            next = cur1
            cur1 = cur1.next
        } else {
            next = cur2
            cur2 = cur2.next
        }

        if (root == null) {
            root = next
            cur3 = next
        }

        cur3?.next = next
        cur3 = next
    }

    if (cur1 != null) {
        if (root == null) {
            root = cur1
        }
        cur3?.next = cur1
    }
    if (cur2 != null) {
        if (root == null) {
            root = cur2
        }
        cur3?.next = cur2
    }
    return root
}
