package leetcode.`kth-largest-element-in-an-array`

import org.junit.Test
import java.util.PriorityQueue

class Solution {
    //基于堆排 时间 NlogK 空间K
    fun findKthLargest2(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>()
        nums.forEach {
            if (heap.size < k) {
                heap.add(it)
            } else {
                heap.add(it)
                heap.poll()
            }
        }
        return heap.poll()
    }

    fun findKthLargest(nums: IntArray, k: Int): Int {
        val targetIndex = nums.size - k
        var p1 = 0
        var p2 = nums.lastIndex
        var arr: IntArray
        while (p1 < p2) {
            arr = parition(nums, p1, p2)
            if (targetIndex in p1 until arr[0]) {
                p2 = arr[0] - 1
            } else if (targetIndex in arr[1]..nums.lastIndex) {
                p1 = arr[1] + 1
            }else{
                return nums[targetIndex]
            }
        }
        return nums[targetIndex]
    }

    fun parition(nums: IntArray, start: Int, end: Int): IntArray {
        var p1 = start - 1
        var p2 = start
        var p3 = end - 1
        while (p2 <= p3) {
            if (nums[p2] < nums[end]) {
                nums.swap(p2++, ++p1)
            } else if (nums[p2] > nums[end]) {
                nums.swap(p2, p3--)
            } else {
                p2++
            }
        }
        nums.swap(p2, end)
        return intArrayOf(p1 + 1, p2)
    }

    fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

    @Test
    fun test() {
//        val array = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)

        val array = intArrayOf(3, 2, 1, 5, 6, 4)
        println(findKthLargest(array, 2))
    }
}