package leetcode.`yong-liang-ge-zhan-shi-xian-dui-lie-lcof`

import java.util.Stack

/**
 * Your CQueue object will be instantiated and called as such:
 * var obj = CQueue()
 * obj.appendTail(value)
 * var param_2 = obj.deleteHead()
 */
class CQueue {
    private val stack1 = Stack<Int>()
    private val stack2 = Stack<Int>()

    fun appendTail(value: Int) {
        if (stack1.isEmpty() && stack2.isNotEmpty()) {
            pourInto(stack2, stack1)
        }
        stack1.push(value)
    }

    fun deleteHead(): Int {
        if (stack1.isEmpty() && stack2.isEmpty()) return -1
        if (stack1.isNotEmpty() && stack2.isEmpty()) {
            pourInto(stack1, stack2)
        }
        return stack2.pop()
    }

    private fun pourInto(fromStack: Stack<Int>, intoStack: Stack<Int>): Stack<Int> {
        while (fromStack.isNotEmpty()) {
            intoStack.push(fromStack.pop())
        }
        return intoStack
    }
}