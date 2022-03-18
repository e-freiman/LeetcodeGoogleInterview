package treesandgraphs

import java.util.LinkedList
import java.util.Queue

fun numIslands(grid: Array<CharArray>): Int {

    val m = grid.size
    val n = grid[0].size

    var islandNumber = 0
    val queue: Queue<Int> = LinkedList()

    for (gi in 0 until m) {
        for (gj in 0 until n) {
            if (grid[gi][gj] == '1') {
                queue.add(gi * n + gj)
                while(!queue.isEmpty()) {
                    val square = queue.poll()
                    val i = square / n
                    val j = square % n
                    if (grid[i][j] == '1') {
                        grid[i][j] = '0'
                        if (i > 0 && grid[i - 1][j] == '1') queue.add((i - 1) * n + j)
                        if (i < m - 1 && grid[i + 1][j] == '1') queue.add((i + 1) * n + j)
                        if (j > 0 && grid[i][j - 1] == '1') queue.add(i * n + j - 1)
                        if (j < n - 1 && grid[i][j + 1] == '1') queue.add(i * n + j + 1)
                    }
                }
                islandNumber++
            }
        }
    }

    return islandNumber
}

fun main() {
    println(numIslands(arrayOf(
        charArrayOf('1','1','1'),
        charArrayOf('0','1','0'),
        charArrayOf('0','1','0'))))
}
