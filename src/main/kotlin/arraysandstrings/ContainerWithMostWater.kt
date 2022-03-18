package arraysandstrings

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        val walls = height.indices.associateBy { height[it] }.toSortedMap()

        var i = 0
        var j = height.size - 1
        var max = 0

        for (h in walls.keys) {
            while (i < height.size && height[i] < h)
                i++

            while (j >= 0 && height[j] < h)
                j--

            if (i >= j)
                break

            max = maxOf(h * (j - i), max)
        }

        return max

    }

    fun maxArea2(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var maxContainer = 0

        while (left < right) {
            var container = minOf(height[left], height[right]) * (right - left)
            if (container > maxContainer) maxContainer = container
            if (height[left] > height[right]) right-- else left++
        }

        return maxContainer
    }
}

fun main() {
    val arr = intArrayOf(10, 2, 1, 10, 1, 2)
    println(ContainerWithMostWater().maxArea2(arr))
}

