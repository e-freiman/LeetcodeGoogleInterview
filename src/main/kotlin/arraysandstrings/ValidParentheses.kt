package arraysandstrings

import java.util.Stack

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()

    for (ch in s) {
        if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch)
        } else {
            if (stack.empty()) return false
            var lastOpening = stack.pop()
            when(ch) {
                ')' -> if (lastOpening != '(') return false
                ']' -> if (lastOpening != '[') return false
                '}' -> if (lastOpening != '{') return false
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValid("()[]{}"))
}
