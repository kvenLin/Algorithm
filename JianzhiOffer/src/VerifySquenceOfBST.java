/**
 * @Author: clf
 * @Date: 18-12-9
 * @Description:
 * 题目描述
 * 输入一个整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0){
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    public boolean verify(int[] sequence, int startIndex, int rootIndex) {
        //判断是否是叶子节点,即没有左右子树
        if (startIndex >= rootIndex){
            return true;
        }
        int leftIndex = rootIndex - 1;
        //找到左子树根节点的索引
        while (leftIndex > startIndex
                && sequence[leftIndex] > sequence[rootIndex]){
            leftIndex --;
        }
        //左子树不能有任何一个节点的值大于根节点的值
        for (int i = startIndex; i < leftIndex; i++){
            if (sequence[i] > sequence[rootIndex]){
                return false;
            }
        }
        //递归判断,左子树和右子树同样满足上述条件
        return verify(sequence, startIndex, leftIndex)
                && verify(sequence, leftIndex + 1, rootIndex - 1);
    }
}
