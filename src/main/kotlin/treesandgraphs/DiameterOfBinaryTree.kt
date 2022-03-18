package treesandgraphs

var diameter = 0

private fun dfs(node: TreeNode?): Int {
    if (node == null) {
        return 0
    }

    val leftDepth = dfs(node.left)
    val rightDepth = dfs(node.right)

    diameter = maxOf(diameter, leftDepth + rightDepth)
    return maxOf(leftDepth, rightDepth) + 1
}

fun diameterOfBinaryTree(root: TreeNode?): Int {
    dfs(root)
    return diameter
}
