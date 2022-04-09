package leetcode.`rotate-list`

import ListNode
import org.junit.Test

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var endP: ListNode? = head ?: return null
        var length = 1
        while (endP?.next != null) {
            endP = endP.next
            length++
        }
        val lastK = k % length
        if (lastK == 0) return head
        endP?.next = head
        var exploreNode = head
        repeat(length - lastK - 1) {
            exploreNode = exploreNode?.next
        }
        val result = exploreNode?.next
        exploreNode?.next = null
        return result
    }

    @Test
    fun test() {
        val li0 = ListNode(0)
        val li1 = ListNode(1)
        val li2 = ListNode(2)
        li0.next = li1
        li1.next = li2
        rotateRight(li0, 4)
    }

    @Test
    fun test2() {
        val li1 = ListNode(1)
        val li2 = ListNode(2)
        li1.next = li2
        rotateRight(li1, 1)
    }
}