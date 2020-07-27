package leetcode

import java.util.*

class ValidParentheses {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (i in s.indices) {
            if (s[i] in listOf('(', '[', '{')) {
                stack.add(s[i])
            } else if (s[i] == ')' && stack.isNotEmpty() && stack.peek() == '(') {
                stack.pop()
            } else if (s[i] == ']' && stack.isNotEmpty() && stack.peek() == '[') {
                stack.pop()
            } else if (s[i] == '}' && stack.isNotEmpty() && stack.peek() == '{') {
                stack.pop()
            } else {
                return false
            }
        }

        if (stack.isEmpty()) return true
        return false
    }
}