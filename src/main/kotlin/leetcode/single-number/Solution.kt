package leetcode.`single-number`

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var k = 0
        nums.forEach { k = k xor it }
        return k
    }
}