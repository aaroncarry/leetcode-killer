package leetcode.`remove-k-digits`

import org.junit.Test
import java.util.Stack

class Solution {
    fun removeKdigits(num: String, k: Int): String {
        if (num.length <= k) return "0"
        var processString = num
        val stack = Stack<Char>()
        repeat(k) {
            processString = greedy(processString, stack)
        }
        return processString.dropWhile { it == '0' }.ifEmpty { "0" }
    }

    fun greedy(num: String, stack: Stack<Char>): String {
        var index = -1

        for (i in stack.size..num.lastIndex) {
            if (stack.isEmpty() || num[i] >= stack.peek()) {
                stack.push(num[i])
            } else {
                index = i - 1
                stack.pop()
                break
            }
        }
        return if (index == -1) {
            num.removeRange(num.lastIndex, num.length)
        } else {
            num.removeRange(index, index + 1)
        }
    }

    @Test
    fun test() {
        removeKdigits("1432219", 3)
        removeKdigits("112", 1)
    }
}