package `remove-nth-node-from-end-of-list`

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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var exploreHead = head
        var exploreEnd = head
        repeat(n) {
            exploreEnd = exploreEnd?.next
        }
        var tempHead: ListNode? = head
        while (exploreEnd != null) {
            exploreEnd = exploreEnd?.next
            tempHead = exploreHead
            exploreHead = exploreHead?.next
        }
        return if (exploreHead == head) {
            head?.next
        } else {
            tempHead?.next = exploreHead?.next
            head
        }
    }

    @Test
    fun test() {
        val li1 = ListNode(1)
        val li2 = ListNode(2)
        val li3 = ListNode(3)
        val li4 = ListNode(4)
        val li5 = ListNode(5)
        li1.next = li2
        li2.next = li3
        li3.next = li4
        li4.next = li5
        removeNthFromEnd(li1, 2)
    }

    @Test
    fun test2() {
        val li1 = ListNode(1)
        removeNthFromEnd(li1, 1)
    }

    @Test
    fun test3() {
        val li1 = ListNode(1)
        val li2 = ListNode(2)
        li1.next=li2
        removeNthFromEnd(li1, 1)
    }
}