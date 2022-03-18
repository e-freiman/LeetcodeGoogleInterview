package arraysandstrings

fun trap(height: IntArray): Int {

    var water = 0

    var i = 0
    var j = height.lastIndex
    var leftMax = 0
    var rightMax = 0

    while (i <= j) {
        if (leftMax < rightMax) {
            val waterColumn = minOf(leftMax, rightMax) - height[i]
            if (waterColumn > 0)
                water += waterColumn
            leftMax = maxOf(leftMax, height[i])
            i++
        } else {
            val waterColumn = minOf(leftMax, rightMax) - height[j]
            if (waterColumn > 0)
                water += waterColumn
            rightMax = maxOf(rightMax, height[j])
            j--
        }
    }

    return water
}

fun main() {
    println(trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
}

