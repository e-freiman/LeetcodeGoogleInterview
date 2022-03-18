package design

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private const val NULL = -1001

class Codec() {

    private fun serializeRecursive(cur: TreeNode?, sb: StringBuilder) {
        sb.append("${cur?.`val` ?: NULL} ")
        if (cur != null) {
            serializeRecursive(cur.left, sb)
            serializeRecursive(cur.right, sb)
        }
    }

    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()
        serializeRecursive(root, sb)
        println(sb.toString())
        return sb.toString()
    }

    private fun deserializeRecursive(data: List<Int>, pos: Int): Pair<TreeNode?, Int> {
        if (data[pos] == NULL) return null to pos + 1

        val node = TreeNode(data[pos])

        val leftPair = deserializeRecursive(data, pos + 1)
        val rightPair = deserializeRecursive(data, leftPair.second)

        node.left = leftPair.first
        node.right = rightPair.first

        return node to rightPair.second

    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        return deserializeRecursive(data.split(' ').filter {!it.isEmpty()}.map {it.toInt()}, 0).first
    }
}
