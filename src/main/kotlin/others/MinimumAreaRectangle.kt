package others

import kotlin.math.abs

fun minAreaRect(points: Array<IntArray>): Int {

    val pointSet = points.map {it[0] to it[1]}.toSet()
    var minArea = Int.MAX_VALUE

    for (i in points.indices) {
        for (j in i + 1..points.lastIndex) {
            if (points[i][0] to points[j][1] in pointSet &&
                points[j][0] to points[i][1] in pointSet) {
                val area = abs((points[i][0] - points[j][0]) * (points[i][1] - points[j][1]))
                if (area > 0) {
                    minArea = minOf(minArea, area)
                }
            }
        }
    }

    return if (minArea < Int.MAX_VALUE) minArea else 0
}

fun main() {
    println(minAreaRect(arrayOf(intArrayOf(1,1),intArrayOf(1,3),intArrayOf(3,1),intArrayOf(3,3),intArrayOf(2,2))))
}
