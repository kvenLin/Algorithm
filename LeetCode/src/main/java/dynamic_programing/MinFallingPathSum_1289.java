package dynamic_programing;

import java.util.Arrays;

/**
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 *
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 *
 */
public class MinFallingPathSum_1289 {

    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= 1) {
                    int lineMin = Integer.MAX_VALUE;
                    for (int k = 0; k < n; k++) {//统计上一行中所有元素中最小值
                        if (k != j) {//排除0偏移的元素
                            lineMin = Math.min(lineMin, dp[i - 1][k]);
                        }
                    }
                    dp[i][j] = lineMin + grid[i][j];
                }else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        int res = Arrays.stream(dp[n - 1]).min().getAsInt();
        return res;
    }

}
