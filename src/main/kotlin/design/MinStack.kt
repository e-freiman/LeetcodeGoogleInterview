package design

data class StackNode(val prev: StackNode?,
                val value: Int,
                val min: Int)

class MinStack() {

    private var stackTop: StackNode? = null

    fun push(`val`: Int) {
        val currentMin = stackTop?.min ?: Int.MAX_VALUE
        stackTop = StackNode(stackTop, `val`, minOf(currentMin, `val`))
    }

    fun pop() {
        stackTop = stackTop?.prev
    }

    fun top() = stackTop!!.value
    fun getMin() = stackTop!!.min
}


fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin()) // return -3
    minStack.pop()
    println(minStack.top()) // return 0
    println(minStack.getMin()) // return -2
}
