package onlineassessment

class FruitIntoBaskets {
    fun totalFruit(fruits: IntArray): Int {
        val basket = mutableMapOf<Int, Int>()
        val pickup = mutableMapOf<Int, Int>()

        var max = 0
        var start = 0
        for (i in fruits.indices) {
            when {
                fruits[i] in basket -> {
                    // basket has required fruit
                    basket[fruits[i]] = basket[fruits[i]]!! + 1
                    pickup[fruits[i]] = i
                }
                basket.size < 2 -> {
                    // basket is empty / half empty
                    basket[fruits[i]] = 1
                    pickup[fruits[i]] = i
                }
                else -> {
                    // basket has to get rid of the fruit which isn't previous
                    val throwawayFruit = basket.keys.find { it != fruits[i - 1] }!!
                    // we need to move to the start of the interval where we start picking, which is right after throwaway fruit
                    for (j in start .. pickup[throwawayFruit]!!) {
                        basket[fruits[j]] = basket[fruits[j]]!! - 1
                    }
                    start = pickup[throwawayFruit]!! + 1

                    basket.remove(throwawayFruit)
                    pickup.remove(throwawayFruit)

                    // add a new fruit to the basket
                    basket[fruits[i]] = 1
                    pickup[fruits[i]] = i
                }
            }
            max = Math.max(basket.values.sum(), max)
        }

        return max
    }
}

fun main() {
    val arr = intArrayOf(1,0,1,4,1,4,1,2,3)
    println(FruitIntoBaskets().totalFruit(arr))
}

