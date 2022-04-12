package leetcode.`remove-duplicates-from-sorted-list`

import ListNode
import org.junit.Test

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var p1 = head
        var p2 = head.next
        while (p1 != null && p2 != null) {
            val temp = p2.next
            if (p1.`val` == p2.`val`) {
                p1.next = p2.next
                p2 = p2.next
                p1 = temp
            } else {
                p2 = p2.next
                p1 = temp
            }
        }
        return head
    }

    @Test
    fun test(){
        var li1 = ListNode(1)
        val li2 = ListNode(1)
        val li3 = ListNode(2)
        val li4 = ListNode(3)
        val li5 = ListNode(3)
        li1.next=li2
        li2.next =li3
        li3.next =li4
        li4.next =li5
        deleteDuplicates(li1)
        while (li1.next!=null){
            println(li1.`val`)
            li1 = li1.next!!
        }
    }
}