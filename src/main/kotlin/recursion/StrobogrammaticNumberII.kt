package recursion

val strobogrammaticNumbers = setOf(
    '0' to '0',
    '1' to '1',
    '6' to '9',
    '8' to '8',
    '9' to '6')

val oddStrobogrammaticNumbers = setOf('0', '1', '8')

private val ret = mutableListOf<String>()

fun traverse(sb: StringBuilder, n: Int) {
    if (sb.length == n) {
        ret.add(sb.toString())
        return
    }

    for (number in strobogrammaticNumbers) {
        if (sb.length < n - 2 || number.first != '0') {
            sb.insert(0, number.first)
            sb.append(number.second)
            traverse(sb, n)
            sb.deleteCharAt(0)
            sb.deleteCharAt(sb.length - 1)
        }
    }
}

fun findStrobogrammatic(n: Int): List<String> {

    val sb = StringBuilder()

    if (n % 2 == 0) {
        traverse(sb, n)
    } else {
        for (number in oddStrobogrammaticNumbers) {
            sb.append(number)
            traverse(sb, n)
            sb.clear()
        }
    }

    return ret
}

fun main() {
    println(findStrobogrammatic(2))
}

