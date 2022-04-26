package leetcode.`binary-search`

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var p1 = 0
        var p2 = nums.lastIndex
        while (p1 <= p2) {
            val mid = (p1 + p2) / 2
            if (nums[mid] > target) {
                p2 = mid - 1
            } else if (nums[mid] < target) {
                p1 = mid + 1
            } else {
                return mid
            }
        }
        return -1
    }
}