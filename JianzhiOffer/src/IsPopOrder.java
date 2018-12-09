import java.util.Stack;

/**
 * @Author: clf
 * @Date: 18-12-4
 * @Description:
 * 题目描述
 * 输入两个整数序列，
 * 第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {

    /**
     * 思路:
     * 1.建立一个辅助栈,将栈的压入序列压入到辅助栈中
     *
     * 2.压栈的过程中,压入一个元素就与弹出序列进行比较,如果辅助栈顶元素与弹出序列相等就弹出
     *
     * 3.最后判断辅助栈元素是否被完全弹出,如果完全弹出了返回true,否则返回FALSE;
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            if (pushA[i] == popA[j]){
                stack.pop();
                j++;
            }
        }
        while (j != popA.length){
            if (stack.pop() != popA[j]){
                return false;
            }
            j ++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {5, 4, 3, 2, 1};
        boolean result = new IsPopOrder().IsPopOrder(pushA, popA);
        System.out.println("result:" + result);
    }
}
