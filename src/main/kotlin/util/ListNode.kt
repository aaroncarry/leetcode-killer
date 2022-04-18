package util

import ListNode
import java.util.TreeSet


fun ListNode.print() {
    val set = TreeSet<ListNode>()
    var exploreP: ListNode? = this
    var count = 1
    while (exploreP != null) {
        print(exploreP.`val`.toString() + " ")
        if (set.contains(exploreP)) {
            print("is a loop linked list,back to ${set.indexOfFirst { it == exploreP }}")
        } else {
            set.add(exploreP)
        }
        exploreP = exploreP.next
        count++
    }
}