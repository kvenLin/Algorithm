import java.util.HashMap;

/**
 * @Author: clf
 * @Date: 18-11-26
 * @Description:
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0){
            return null;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < in.length; j++) {
                if (pre[i] == in[j]){
                    //存取前序遍历元素在中序遍历数组中的索引
                    hashMap.put(pre[i],j);
                }
            }
        }
        return createPre(0, pre.length - 1, pre, hashMap);
    }

    private TreeNode createPre(int startIndex, int endIndex, int[] pre, HashMap<Integer,Integer> map){
        if (startIndex > endIndex){
            return null;
        }
        TreeNode root = new TreeNode(pre[startIndex]);
        if (startIndex == endIndex){
            return root;
        }
        //用k判断遍历过程是否存在右子树
        int k = -1;
        for (int i = startIndex; i <= endIndex; i ++){
            //通过查询对应的中序遍历的索引进行判断
            if (map.get(pre[i]) > map.get(pre[startIndex])){
                k = i;
                break;
            }
        }
        if (k != -1){
            root.left = createPre(startIndex + 1, k - 1, pre, map);
            root.right = createPre(k, endIndex, pre, map);
        }else {
            root.left = createPre(startIndex + 1, endIndex, pre, map);
        }
        return root;
    }

    /**
     * 校验中序遍历的结果是否正确
     * @param root
     */
    private void printTree(TreeNode root) {
        if(root != null) {
            printTree(root.left);
            System.out.println(root.val + " ");
            printTree(root.right);
        }
    }

}
