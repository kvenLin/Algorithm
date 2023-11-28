package dynamic_programing;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs_70 {
    public static int climbStairs(int n) {
        int[] memo = new int[n + 2];
        memo[1] = 1;
        memo[2] = 2;
        if (n == 1 || n == 2) {
            return memo[n];
        }
        for (int i = 3; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }

}
