package leetcode.`find-the-duplicate-number`

import org.junit.Test

class Solution {
    fun findDuplicate(nums: IntArray): Int {
        val head = nums.first()
        //抽象链表成环法
        var fastP = fastTransfer(head, nums)
        var slowP = transfer(head, nums)
        while (fastP != slowP) {
            fastP = fastTransfer(fastP, nums)
            slowP = transfer(slowP, nums)
        }
        var startP = head
        while (slowP != startP) {
            slowP = transfer(slowP, nums)
            startP = transfer(startP, nums)
        }
        return slowP
    }

    fun transfer(index: Int, nums: IntArray): Int {
        return nums[index]
    }

    fun fastTransfer(index: Int, nums: IntArray): Int {
        return transfer(transfer(index, nums), nums)
    }

    //---------基于二分法
    fun findDuplicateByBinary(nums: IntArray): Int {
        var pLeft = 1
        var pRight = nums.size - 1
        while (pLeft != pRight) {
            val mid = (pLeft + pRight) / 2
            if (nums.count { it in pLeft..mid } > (mid - pLeft + 1)) {
                pRight = mid
            } else {
                pLeft = mid + 1
            }
        }
        return pLeft
    }

    @Test
    fun test() {
        findDuplicateByBinary(intArrayOf(1, 3, 4, 2, 2))
    }
}