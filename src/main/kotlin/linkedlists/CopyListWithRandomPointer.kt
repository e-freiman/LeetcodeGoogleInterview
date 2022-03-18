package linkedlists

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
 }


class Solution {

    fun copyRandomList(node: Node?): Node? {
        var inputNode = node

        if (inputNode == null) {
            return null
        }

        val root = Node(inputNode.`val`)
        var cur = root

        val relation = mutableMapOf<Node, Node>(inputNode to root)

        inputNode = inputNode.next

        // copy
        while(inputNode != null) {
            cur.next = Node(inputNode.`val`)
            relation[inputNode] = cur.next!!

            cur = cur.next!!
            inputNode = inputNode.next
        }

        // assigning random pointers
        inputNode = node
        while(inputNode != null) {
            relation[inputNode]!!.random = relation[inputNode.random]
            inputNode = inputNode.next
        }

        return root
    }
}
