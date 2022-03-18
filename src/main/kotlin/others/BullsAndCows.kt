package others

fun getHint(secret: String, guess: String): String {
    val digits = secret.groupingBy { it }.eachCount().toMutableMap()

    var bulls = 0
    for (i in guess.indices) {
        if (secret[i] == guess[i]) {
            bulls++
            digits[guess[i]] = digits[guess[i]]!! - 1
            if (digits[guess[i]] == 0) digits.remove(guess[i])
        }
    }

    var cows = 0
    for (i in guess.indices) {
        if (guess[i] != secret[i] && guess[i] in digits) {
            cows++
            digits[guess[i]] = digits[guess[i]]!! - 1
            if (digits[guess[i]] == 0) digits.remove(guess[i])
        }
    }
    return "${bulls}A${cows}B"
}

fun main() {
    println(getHint("1807", "7810"))
}
