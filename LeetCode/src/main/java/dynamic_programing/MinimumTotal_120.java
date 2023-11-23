package dynamic_programing;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 */
public class MinimumTotal_120 {


    /**
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     * 思路:
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int val = triangle.get(i).get(j);
                dp[i][j] = Integer.MAX_VALUE;
                if (j != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + val, dp[i][j]);
                }
                if (j != i) {
                    dp[i][j] = Math.min(dp[i - 1][j] + val, dp[i][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) ans = Math.min(ans, dp[n - 1][i]);
        return ans;

    }

    public static void main(String[] args) {
        MinimumTotal_120 minimumTotal120 = new MinimumTotal_120();
        int data = minimumTotal120.minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)));
        System.out.println(data);
    }
}
