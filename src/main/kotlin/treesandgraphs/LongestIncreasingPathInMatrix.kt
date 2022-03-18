package treesandgraphs

private var memo: Array<IntArray>? = null

private fun dfs(matrix: Array<IntArray>, i: Int, j: Int): Int {

    if (memo!![i][j] != -1) {
        return memo!![i][j]
    }

    var maxLength = 0

    if (i > 0 && matrix[i - 1][j] > matrix[i][j])
        maxLength = maxOf(maxLength, dfs(matrix, i - 1, j))
    if (j > 0 && matrix[i][j - 1] > matrix[i][j])
        maxLength = maxOf(maxLength, dfs(matrix, i, j - 1))
    if (i < matrix.lastIndex && matrix[i + 1][j] > matrix[i][j])
        maxLength = maxOf(maxLength, dfs(matrix, i + 1, j))
    if (j < matrix[i].lastIndex && matrix[i][j + 1] > matrix[i][j])
        maxLength = maxOf(maxLength, dfs(matrix, i, j + 1))

    memo!![i][j] = maxLength + 1
    return maxLength + 1
}

fun longestIncreasingPath(matrix: Array<IntArray>): Int {

    memo = Array<IntArray>(matrix.size) { IntArray(matrix[it].size) { -1 } }

    var maxLength = 0

    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            maxLength = maxOf(maxLength, dfs(matrix, i, j))
        }
    }

    return maxLength
}
