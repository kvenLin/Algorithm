import java.util.ArrayList;

/**
 * @Author: clf
 * @Date: 18-12-9
 * @Description:
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，
 * /打印出二叉树中结点值的和为输入整数/ 的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private ArrayList<Integer> path = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return ret;
        }
        path.add(root.val);
        //当前路径满足条件
        if (root.left == null && root.right == null && root.val == target){
            ret.add(new ArrayList<>(path));
        }
        //向左子树进行遍历
        if (root.val < target && root.left != null){
            FindPath(root.left, target - root.val);
        }
        //向右子树进行遍历
        if (root.val < target && root.right != null){
            FindPath(root.right, target - root.val);
        }
        path.remove(path.size() - 1);
        return ret;
    }

}
