package leetcode.`remove-k-digits`

import org.junit.Test

class Solution {
    fun removeKdigits(num: String, k: Int): String {
        if (num.length <= k) return "0"
        var processString = num
        repeat(k) {
            processString = greedy(processString)
        }
        return processString.dropWhile { it == '0' }.ifEmpty { "0" }
    }

    fun greedy(num: String): String {
        var index = -1
        for (i in 1..num.lastIndex) {
            if (num[i] < num[i - 1]) {
                index = i - 1
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
//        removeKdigits("1432219", 3)
        removeKdigits("112", 1)
    }
}