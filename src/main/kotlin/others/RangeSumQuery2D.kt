package others

class NumMatrix(private val matrix: Array<IntArray>) {

    fun update(row: Int, col: Int, `val`: Int) {
        matrix[row][col] = `val`
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var sum = 0
        for (i in row1..row2) {
            for (j in col1..col2) {
                sum += matrix[i][j]
            }
        }
        return sum
    }
}
