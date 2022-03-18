package design

import java.util.Deque
import java.util.LinkedList

private const val DELTA = 10

class LoggerRateLimiter {

    private val messages = mutableSetOf<String>()
    private val timestamps: Deque<Pair<Int, String>> = LinkedList()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {

        while (!timestamps.isEmpty() && timestamps.peekFirst().first <= timestamp - DELTA) {
            var p = timestamps.pollFirst()
            messages.remove(p.second)
        }

        if (message in messages) {
            return false
        }

        messages.add(message)
        timestamps.addLast(timestamp to message)
        return true
    }
}

fun main() {
    val logger = LoggerRateLimiter()
    println(logger.shouldPrintMessage(1, "foo")) // return true, next allowed timestamp for "foo" is 1 + 10 = 11
    println(logger.shouldPrintMessage(2, "bar")) // return true, next allowed timestamp for "bar" is 2 + 10 = 12
    println(logger.shouldPrintMessage(3, "foo")) // 3 < 11, return false
    println(logger.shouldPrintMessage(8, "bar")) // 8 < 12, return false
    println(logger.shouldPrintMessage(10, "foo")) // 10 < 11, return false
    println(logger.shouldPrintMessage(11, "foo")) // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
}
