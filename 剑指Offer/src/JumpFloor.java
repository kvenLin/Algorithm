/**
 * @Author: clf
 * @Date: 18-11-26
 * @Description:
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {
    /**
     * 思路：
     * 类似Fibonacci，总数 = 最后一次选择跳1次 + 最后一次选择跳2次
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1 ){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
