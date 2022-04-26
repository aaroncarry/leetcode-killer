package leetcode.`kth-largest-element-in-an-array`

import java.util.PriorityQueue

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
        nums.forEach { heap.add(it) }
        repeat(k - 1){
            heap.poll()
        }
        return heap.poll()
    }
}