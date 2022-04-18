package leetcode.`binary-tree-postorder-traversal`

import TreeNode

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val arrayList = arrayListOf<Int>()
        travel(root, arrayList)
        return arrayList
    }

    private fun travel(treeNode: TreeNode?, list: ArrayList<Int>): List<Int> {
        if (treeNode == null) return list
//        print(treeNode.`val`)
        travel(treeNode.left, list)
        travel(treeNode.right, list)
        list.add(treeNode.`val`)
        return list
    }
}