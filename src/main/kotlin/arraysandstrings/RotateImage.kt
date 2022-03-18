package arraysandstrings

class RotateImage {
    private fun swap(i1: Int, j1: Int, i2: Int, j2: Int, matrix: Array<IntArray>) {
        val temp = matrix[i1][j1]
        matrix[i1][j1] = matrix[i2][j2]
        matrix[i2][j2] = temp
    }

    fun rotate(matrix: Array<IntArray>): Unit {
        // transpose the matrix
        for(i in matrix.indices) {
            for (j in i..matrix.lastIndex) {
                swap(i, j, j, i, matrix)
            }
        }

        //mirror vertically
        for(i in matrix.indices) {
            for (j in 0..matrix.lastIndex / 2) {
                swap(i, j, i, matrix.size - j - 1, matrix)
            }
        }
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(5,1,9,11),
        intArrayOf(2,4,8,10),
        intArrayOf(13,3,6,7),
        intArrayOf(15,14,12,16))

    RotateImage().rotate(matrix)

    println(matrix.contentDeepToString())
}


