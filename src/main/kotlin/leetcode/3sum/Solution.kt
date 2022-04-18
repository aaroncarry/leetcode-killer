package leetcode.`3sum`

import org.junit.Test

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val resultList = arrayListOf<List<Int>>()
        if (nums.size < 3) return resultList
        nums.sort()
        for (i in 0 until nums.lastIndex - 1) {
            val target = 0 - nums[i]
            var p1 = i + 1
            var p2 = nums.lastIndex
            while (p1 < p2) {
                if ((nums[p1] + nums[p2]) == target) {
                    val result = listOf(nums[p1], nums[i], nums[p2])
                    if (!resultList.contains(result)) resultList.add(result)
                    p1++
                } else if (target > (nums[p1] + nums[p2])) {
                    p1++
                } else {
                    p2--
                }
            }
        }
        return resultList
    }


    @Test
    fun test() {
        val test = intArrayOf(-1, 0, 1, 2, -1, -4)
        threeSum(test)
    }
}