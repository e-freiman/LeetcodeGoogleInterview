package arraysandstrings

import java.util.SortedSet
import java.util.TreeSet

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {

        // O(N*log(N))
        val numsMap = mutableMapOf<Int, SortedSet<Int>>()
        for (i in nums.indices) {
            if (nums[i] !in numsMap) {
                numsMap[nums[i]] = sortedSetOf()
            }
            numsMap[nums[i]]!!.add(i)
        }

        val res = mutableSetOf<List<Int>>()

        // O(N^2)
        for (i in nums.indices) {
            for (j in i + 1 .. nums.lastIndex) {
                val iter = numsMap[- nums[i] - nums[j]]?.tailSet(j + 1)?.iterator()
                if (iter?.hasNext() == true) {
                    val k = iter.next()
                    res.add(listOf(nums[i], nums[j] ,nums[k]).sorted())
                }
            }
        }
        return res.toList()
    }
}

fun main() {
    println(ThreeSum().threeSum(intArrayOf(-1,0,1,2,-1,-4)))
}

