package leetcode.`maximum-width-of-binary-tree`

import TreeNode
import org.junit.Test
import java.util.LinkedList
import kotlin.math.abs

class Solution {
    fun widthOfBinaryTree(root: TreeNode?): Int {
        root ?: return 0
        val queue = LinkedList<PostionTreeNode>()
        var currentDep = 0
        var maxWidth = 1
        var f: Int? = null
        queue.push(PostionTreeNode(root, 0, 1))
        while (queue.isNotEmpty()) {
            val k = queue.poll() as PostionTreeNode
            if (currentDep != k.depth) {
                currentDep = k.depth
                f = k.postion
            } else {
                if (f == null) {
                    f = k.postion
                }
                maxWidth = Math.max(maxWidth, k.postion - f + 1)
            }
            if (k.node.left != null) {
                queue.offer(PostionTreeNode(k.node.left!!, k.postion * 2, k.depth+1))
            }
            if (k.node.right != null) {
                queue.offer(PostionTreeNode(k.node.right!!, k.postion * 2 + 1, k.depth+1))
            }
        }
        return maxWidth
    }

    class PostionTreeNode(val node: TreeNode, val postion: Int, val depth: Int)

    @Test
    fun test() {
//        [1,3,2,5,null,null,9,6,null,7]
        val root = TreeNode(1)
        val node1 = TreeNode(3)
        val node2 = TreeNode(2)
        val node3 = TreeNode(5)
        val node4 = TreeNode(5)
        val node5 = TreeNode(5)
        val node6 = TreeNode(5)

        root.left = node1
        root.right = node2

        node1.left = node3
        node3.left = node4

        node2.right = node5
        node5.left = node6
        widthOfBinaryTree(root)
    }
}