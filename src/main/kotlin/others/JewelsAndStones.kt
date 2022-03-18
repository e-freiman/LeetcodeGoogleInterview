package others

fun numJewelsInStones(jewels: String, stones: String): Int {
    val jewelSet = jewels.toSet()
    return stones.toCharArray().count { it in jewelSet }
}
