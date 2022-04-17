package leetcode.`palindrome-linked-list`

import ListNode

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) return true
        var slowP = head
        var fastP = head
        while (fastP != null) {
            slowP = slowP?.next
            fastP = fastP.next?.next
        }
        var lastP: ListNode? = null
        while (slowP != null) {
            val next = slowP.next
            slowP.next = lastP
            lastP = slowP
            slowP = next
        }
        var startP = head
        while (startP != null && lastP != null) {
            if (startP.`val` != lastP.`val`) return false
            startP = startP.next
            lastP = lastP.next
        }

        return true
    }

//    fun isPalindrome(head: ListNode?): Boolean {
//        if (head?.next == null) return true
//        val stack = Stack<Int>()
//        var tag = head
//        while (tag != null) {
//            stack.push(tag.`val`)
//            tag = tag.next
//        }
//        var start = head
//        while (start != null) {
//            if (start.`val` != stack.pop()) {
//                return false
//            }
//            start = start.next
//        }
//        return true
//    }
}