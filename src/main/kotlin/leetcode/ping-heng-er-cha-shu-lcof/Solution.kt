package leetcode.`ping-heng-er-cha-shu-lcof`

import TreeNode
import kotlin.math.abs

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return process(root).isBalance
    }

    private fun process(treeNode: TreeNode?): ReturnType {
        if (treeNode == null) return ReturnType(true, 0)

        val left = process(treeNode.left)
        val right = process(treeNode.right)
        val isBalance = left.isBalance && right.isBalance && Math.abs(left.height - right.height) < 2
        val height = Math.max(left.height, right.height) + 1
        return ReturnType(isBalance, height)
    }


    class ReturnType(var isBalance: Boolean, var height: Int)
}