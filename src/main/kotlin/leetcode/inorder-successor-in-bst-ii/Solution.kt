package leetcode.`inorder-successor-in-bst-ii`

import TreeNode

class Solution {
    fun inorderSuccessor(node: Node?): Node? {
        node ?: return null
        var explore: Node?
        return if (node.right == null) {
            explore = node
            while (explore != null && explore == explore.parent?.right) explore = explore.parent
            explore?.parent
        } else {
            explore = node.right
            while (explore?.left != null) explore = explore.left
            explore
        }
    }

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var parent: Node? = null
    }
}