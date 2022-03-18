package design

import java.util.Random

class RandomizedSet() {
    private val dataMap = mutableMapOf<Int, Int>()
    private val dataArray = mutableListOf<Int>()
    private val rnd = Random()

    fun insert(`val`: Int): Boolean {
        if (`val` in dataMap) return false
        dataArray.add(`val`)
        dataMap[`val`] = dataArray.lastIndex
        return true
    }

    fun remove(`val`: Int): Boolean {
        if (`val` !in dataMap) return false
        val index = dataMap[`val`]!!

        if (index != dataArray.lastIndex) {
            dataArray[index] = dataArray.last()
            dataMap[dataArray[index]] = index
        }

        dataMap.remove(`val`)
        dataArray.removeAt(dataArray.lastIndex)
        return true
    }

    fun getRandom() = dataArray[rnd.nextInt(dataArray.size)]
}

fun main() {
    val randomizedSet = RandomizedSet()
    println(randomizedSet.insert(1))// Inserts 1 to the set. Returns true as 1 was inserted successfully.
    println(randomizedSet.remove(2)) // Returns false as 2 does not exist in the set.
    println(randomizedSet.insert(2)) // Inserts 2 to the set, returns true. Set now contains [1,2].
    println(randomizedSet.getRandom()) // getRandom() should return either 1 or 2 randomly.
    println(randomizedSet.remove(1)) // Removes 1 from the set, returns true. Set now contains [2].
    println(randomizedSet.insert(2)) // 2 was already in the set, so return false.
    println(randomizedSet.getRandom()) // Since 2 is the only number in the set, getRandom() will always return 2.
}
