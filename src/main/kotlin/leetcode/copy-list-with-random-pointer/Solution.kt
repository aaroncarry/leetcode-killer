package leetcode.`copy-list-with-random-pointer`

class Solution {
    fun copyRandomList(node: Node?): Node? {
        node ?: return null
        var p = node
        while (p != null) {
            val copyP = Node(p.`val`)
            copyP.next = p.next
            p.next = copyP
            p = copyP.next
        }
        p = node
        while (p != null) {
            p.next?.random = p.random?.next
            p = p.next?.next
        }
        p = node
        var oldNode: Node? = null
        var result: Node? = null
        var copyP = result
        var count = 0
        while (p != null) {
            if (count % 2 == 0) {
                if (oldNode == null) {
                    oldNode = p
                } else {
                    oldNode.next = p
                    oldNode = oldNode.next
                }
            } else {
                if (result == null) {
                    result = p
                    copyP = result
                } else {
                    copyP?.next = p
                    copyP = copyP?.next
                }
            }
            count++
            p = p.next
        }
        oldNode?.next = null
        copyP?.next = null
        return result
    }


    //O(N)
//    fun copyRandomList(node: Node?): Node? {
//        node ?: return null
//        var p = node
//        var head: Node? = null
//        val map = hashMapOf<Node, Node?>()
//        var copyP: Node? = null
//        while (p != null) {
//            if (head == null) {
//                head = Node(p.`val`)
//                copyP = head
//                map[p] = head
//            } else {
//                val copyNode = Node(p.`val`)
//                map[p] = copyNode
//                copyP?.next = copyNode
//                copyP = copyP?.next
//            }
//            p = p.next
//        }
//        p = node
//        copyP = head
//        while (p != null) {
//            copyP?.random = map[p.random]
//            copyP = copyP?.next
//            p = p.next
//        }
//        return head
//    }
}


class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}