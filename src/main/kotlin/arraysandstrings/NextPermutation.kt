package arraysandstrings

class NextPermutation {
    private fun swap(nums: IntArray, i: Int, j: Int) {
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }

    private fun reverse(nums: IntArray, start: Int, end: Int) {
        var i = start
        var j = end
        while(i < j) {
            swap(nums, i++, j--)
        }
    }

    fun nextPermutation(nums: IntArray): Unit {
        var target: Int? = null
        for(i in nums.lastIndex downTo 1) {
            if (nums[i - 1] < nums[i]) {
                target = i - 1
                break
            }
        }

        if (target == null) {
            reverse(nums, 0, nums.lastIndex)
        } else {
            var source: Int? = null
            for (i in nums.lastIndex downTo target + 1) {
                if (nums[i] > nums[target]) {
                    if (source == null) {
                        source = i
                    } else if(nums[i] - nums[target] < nums[source] - nums[target]) {
                        source = i
                        break
                    }
                }
            }
            swap(nums, source!!, target)
            reverse(nums, target + 1, nums.lastIndex)
        }
    }
}

fun main() {
    val arr = intArrayOf(2,3,1)
    println(arr.contentToString())
    for (i in 0..3) {
        NextPermutation().nextPermutation(arr)
        println(arr.contentToString())
    }
}

