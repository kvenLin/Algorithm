/**
 * @Author: clf
 * @Date: 18-12-11
 * @Description:
 * 题目描述
 * 输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，
 * 只能调整树中结点指针的指向。
 */
public class TreeConvertToDuLinkList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastNode = null;
        TreeNode headNode = createList(pRootOfTree, lastNode);
        while (headNode != null && headNode.left != null) {
            headNode = headNode.left;
        }
        return headNode;
    }

    private TreeNode createList(TreeNode rootTree, TreeNode lastNode) {
        if (rootTree == null) {
            return null;
        }
        if (rootTree.left != null) {
            lastNode=createList(rootTree.left, lastNode);
        }
        rootTree.left = lastNode;
        if (lastNode != null) {
            lastNode.right = rootTree;
        }
        lastNode = rootTree;
        if (rootTree.right != null) {
            lastNode=createList(rootTree.right, lastNode);
        }
        return lastNode;
    }


}
