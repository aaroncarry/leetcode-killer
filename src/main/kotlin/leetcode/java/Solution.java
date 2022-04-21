package leetcode.java;


//lowest-common-ancestor-of-a-binary-search-tree
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q).treeNode;
    }

    public ReturnType process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return new ReturnType(root);
        ReturnType left = process(root.left, p, q);
        ReturnType right = process(root.right, p, q);
        if (left.treeNode != null && right.treeNode != null) {
            return new ReturnType(root);
        }
        return left.treeNode == null ? right : left;
    }

    class ReturnType {
        public TreeNode treeNode;

        public ReturnType(TreeNode treeNode) {
            this.treeNode = treeNode;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}