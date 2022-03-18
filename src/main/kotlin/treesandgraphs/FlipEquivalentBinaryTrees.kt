package treesandgraphs

private fun dfs(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null || root2 == null) {
        return root1 == root2
    }
    if (root1.`val` != root2.`val`) {
        return false
    }
    return dfs(root1.left, root2.left) && dfs(root1.right, root2.right) ||
            dfs(root1.left, root2.right) && dfs(root1.right, root2.left)
}

fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
    return dfs(root1, root2)
}
