package newcode

import org.junit.Test
import java.util.Stack

class ReverseStackByRec {

    fun reverse(stack: Stack<Int>): Stack<Int> {
        if (stack.isEmpty()) return stack
        val last = getLast(stack, stack.pop())
        reverse(stack)
        stack.push(last)
        return stack
    }

    private fun getLast(stack: Stack<Int>, last: Int): Int {
        return if (stack.isEmpty()) {
            last
        } else {
            val result = getLast(stack, stack.pop())
            stack.push(last)
            result
        }
    }

    @Test
    fun test() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        reverse(stack)
        while (!stack.isEmpty()) {
            println(stack.pop())
        }
    }
}