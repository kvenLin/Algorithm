import java.util.Stack;
/**
 * @Author: clf
 * @Date: 18-12-3
 * @Description:
 * 题目描述
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class StackMin {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min_stack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min_stack.isEmpty() || min_stack.peek() >= node){
            min_stack.push(node);
        }else {
            min_stack.push(min_stack.peek());
        }
    }

    public void pop() {
        if (stack.isEmpty() || min_stack.isEmpty()){
            return;
        }
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        if (stack.isEmpty()){
            return 0;
        }
        return stack.peek();
    }

    public int min() {
        if (min_stack.isEmpty()){
            return 0;
        }
        return min_stack.peek();
    }
}
