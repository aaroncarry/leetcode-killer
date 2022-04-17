package leetcode.`reverse-linked-list`

import ListNode

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var p1:ListNode? = null
        var p2 = head
        while (p2 != null){
            val next = p2.next
            p2.next = p1
            p1 = p2
            p2 = next
        }
        return p1
    }
}