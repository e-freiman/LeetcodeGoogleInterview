package others

val pairs = mapOf(
    '0' to '0',
    '1' to '1',
    '6' to '9',
    '8' to '8',
    '9' to '6')

val centralNumbers = setOf('0', '1', '8')

fun isStrobogrammatic(num: String): Boolean {
    var i = 0
    var j = num.lastIndex

    while (i < j) {
        if (pairs[num[i++]] != num[j--]) {
            return false
        }
    }

    if (i == j) {
        return num[i] in centralNumbers
    }

    return true
}

fun main() {
    println(isStrobogrammatic("69"))
}
