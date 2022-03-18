package others

fun reverse(x: Int): Int {
    var x = x
    var y = 0
    while (x != 0) {
        val digit = x % 10
        x /= 10

        if (y > Int.MAX_VALUE / 10 || y < Int.MIN_VALUE / 10) {
            return 0
        }
        y = 10 * y + digit
    }
    return y
}

fun main() {
    println(reverse(-123))
}
