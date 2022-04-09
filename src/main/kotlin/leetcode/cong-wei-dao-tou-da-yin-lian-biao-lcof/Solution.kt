package leetcode.`cong-wei-dao-tou-da-yin-lian-biao-lcof`

import ListNode

class Solution {
    fun reversePrint(head: ListNode?): IntArray {
        if (head == null) return intArrayOf()
        return recPrint(head)
    }

    fun recPrint(node: ListNode): IntArray {
        if (node.next == null) return intArrayOf(node.`val`)
        return reversePrint(node.next).plus(node.`val`)
    }
}