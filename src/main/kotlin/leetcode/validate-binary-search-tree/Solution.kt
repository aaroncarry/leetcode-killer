package leetcode.`validate-binary-search-tree`

import TreeNode
import org.junit.Test

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return process(root)!!.isBST
    }

    private fun process(node: TreeNode?): ReturnType? {
        if (node == null) return null

        val left = process(node.left)
        val right = process(node.right)

        var min: Int = node.`val`
        var max: Int = node.`val`
        var isBST = true
        if (left != null) {
            min = Math.min(left.min, node.`val`)
            max = Math.max(left.max, node.`val`)
            isBST = left.isBST && node.`val` > left.max
        }
        if (right != null) {
            min = Math.min(right.min, min)
            max = Math.max(right.max, max)
            isBST = isBST && right.isBST && node.`val` < right.min
        }

        return ReturnType(isBST, min, max)
    }

    class ReturnType(var isBST: Boolean, var min: Int, var max: Int)

    @Test
    fun test(){
        val node1 = TreeNode(5)
        val node2 = TreeNode(4)
        val node3 = TreeNode(6)
        val node4 = TreeNode(3)
        val node5 = TreeNode(7)
        node1.left = node2
        node1.right = node3
        node3.left = node4
        node3.right = node5
        isValidBST(node1)
    }
}