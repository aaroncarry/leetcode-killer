package leetcode.`add-two-numbers`

import ListNode
import kotlin.math.pow

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var head: ListNode? = null
        var mergeNode: ListNode? = null
        var increase = 0
        var p1 = l1
        var p2 = l2
        while (p1 != null || p2 != null) {
            var v1 = 0
            var v2 = 0
            if (p1 != null) {
                v1 = p1.`val`
                p1 = p1.next
            }
            if (p2 != null) {
                v2 = p2.`val`
                p2 = p2.next
            }
            var sum = v1 + v2 + increase
            increase = sum / 10
            sum %= 10
            if (head == null) {
                head = ListNode(sum)
                mergeNode = head
            } else {
                mergeNode?.next = ListNode(sum)
                mergeNode = mergeNode?.next
            }
        }
        if (increase != 0) {
            mergeNode?.next = ListNode(increase)
        }
        return head
    }

}