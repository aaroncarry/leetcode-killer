package leetcode.`contains-duplicate`

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        nums.sort()
        for (i in 1..nums.lastIndex) {
            if (nums[i] == nums[i - 1]) {
                return true
            }
        }
        return false
    }
}