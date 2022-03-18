package treesandgraphs

var abort = false
var bottomNodes = 0
var h = 0

fun dfs(node: TreeNode?, level: Int) {
    if (abort || node == null) {
        return
    }

    if (level > h) {
        bottomNodes++
    } else if (node.left == null && node.right == null){
        abort = true
    }

    dfs(node.left, level + 1)
    dfs(node.right, level + 1)
}

fun countNodes(root: TreeNode?): Int {
    var cur = root
    var bodyNodes = 0
    while(cur != null) {
        cur = cur?.right
        bodyNodes += Math.pow(2.0, h.toDouble()).toInt()
        h++
    }
    h--

    dfs(root, 0)

    return bodyNodes + bottomNodes
}
