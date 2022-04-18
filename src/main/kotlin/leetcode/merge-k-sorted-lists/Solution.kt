package leetcode.`merge-k-sorted-lists`

import ListNode
import java.util.PriorityQueue

class Solution {
    //有时间可以看一下分治的解法:https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val minHeap = PriorityQueue<Int>()
        var merge: ListNode? = null
        var head: ListNode? = null
        for (i in lists.indices) {
            while ((lists[i] != null)){
                minHeap.add(lists[i]?.`val`)
                lists[i] = lists[i]?.next
            }
        }
        while (minHeap.isNotEmpty()){
            if (merge == null) {
                merge = ListNode(minHeap.poll())
                head = merge
            } else {
                merge.next = ListNode(minHeap.poll())
                merge = merge.next
            }
        }
        return head
    }
}