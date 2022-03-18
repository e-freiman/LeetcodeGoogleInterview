package recursion

private val visited = BooleanArray(9) {false}

fun valid(i: Int, j: Int, ni: Int, nj: Int): Boolean {

    val di = Math.abs(i - ni)
    val dj = Math.abs(j - nj)

    return if ((di == 2 && dj == 2) || (di == 0 && dj == 2) || (di == 2 && dj == 0)) {
        val mi = (i + ni) / 2
        val mj = (j + nj) / 2
        visited[3 * mi + mj]
    } else {
        true
    }
}

fun traverse(i: Int, j: Int, m: Int, n: Int, length: Int): Int {
    visited[3 * i + j] = true
    var counter = 0
    if (length >= m && length <= n) {
        counter++
    }

    for (ni in 0..2) {
        for (nj in 0..2) {
            if (!visited[3 * ni + nj] && valid(i, j, ni, nj)) {
                counter += traverse(ni, nj, m, n, length + 1)
            }
        }
    }

    visited[3 * i + j] = false
    return counter
}

fun numberOfPatterns(m: Int, n: Int): Int {
    var counter = 0
    for (i in 0..2) {
        for (j in 0..2) {
            counter += traverse(i, j, m, n, 1)
        }
    }
    return counter
}

fun main() {
    println(numberOfPatterns(1, 2))
}
