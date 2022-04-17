package util

import ListNode

object ListNodeUtil {
    fun generate(intArray: IntArray): ListNode {
        lateinit var head: ListNode
        var tmp: ListNode? = null
        intArray.forEachIndexed { index, i ->
            if (index == 0) {
                head = ListNode(i)
                tmp = head
            } else {
                tmp?.next = ListNode(i)
                tmp = tmp?.next
            }
        }
        return head
    }
}