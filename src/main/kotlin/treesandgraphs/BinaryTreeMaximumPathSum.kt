package treesandgraphs

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

var maxPathValue = Int.MIN_VALUE

private fun dfs(root: TreeNode?): Int {
    if (root == null) return 0
    val leftVal = dfs(root.left)
    val rightVal = dfs(root.right)

    var thisVal = root.`val` + maxOf(leftVal, 0) + maxOf(rightVal, 0)
    maxPathValue = maxOf(thisVal, maxPathValue)

    return root.`val` + maxOf(leftVal, rightVal, 0)
}

fun maxPathSum(root: TreeNode?): Int {
    dfs(root)
    return maxPathValue
}
