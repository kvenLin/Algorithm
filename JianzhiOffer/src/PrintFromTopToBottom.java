import java.util.ArrayList;

/**
 * @Author: clf
 * @Date: 18-12-4
 * @Description:
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        result.add(root.val);
        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(root.left);
        nodes.add(root.right);
        return print(result, nodes);
    }

    public ArrayList<Integer> print(ArrayList<Integer> result, ArrayList<TreeNode> nodes){
        ArrayList<TreeNode> temp = new ArrayList<>();
        if (nodes.size() == 0){
            return result;
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) == null) {
                continue;
            }
            result.add(nodes.get(i).val);
            temp.add(nodes.get(i).left);
            temp.add(nodes.get(i).right);
        }
        return print(result, temp);
    }
}
