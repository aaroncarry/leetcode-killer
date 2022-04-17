package leetcode.`intersection-of-two-linked-lists`

import ListNode
import org.junit.Test
import util.ListNodeUtil

class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var pA = headA
        while (pA?.next != null) {
            if (headB == pA) return headB
            pA = pA.next
        }
        if (pA == headB) return headB
        pA?.next = headA
        val endA = pA
        var slowP = headB
        var fastP = headB
        while ((slowP != fastP && slowP != null && fastP != null) || slowP == headB) {
            slowP = slowP?.next
            fastP = fastP?.next?.next
        }
        slowP = headB
        while ((slowP != fastP && slowP != null && fastP != null) || slowP == headB) {
            slowP = slowP?.next
            fastP = fastP?.next
        }
        endA?.next = null
        return fastP
    }

    @Test
    fun test(){
        val list1 = ListNodeUtil.generate(intArrayOf(8,4,5))
    }
}