package dynamic_programing;

import java.util.Arrays;

/**
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 */
public class MinFallingPathSum_931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= 1) {
                    int left = j > 0 ? Math.min(dp[i - 1][j - 1] + matrix[i][j], Integer.MAX_VALUE) : Integer.MAX_VALUE;// 左上元素是否存在
                    int middle = dp[i - 1][j] + matrix[i][j];//正上方元素
                    int right = j < n - 1 ? Math.min(dp[i - 1][j + 1] + matrix[i][j], Integer.MAX_VALUE) : Integer.MAX_VALUE;//右上方元素是否存在
                    dp[i][j] = Math.min(Math.min(left, middle), right);
                }else {
                    dp[i][j] = matrix[i][j];
                }
            }
        }
        int res = Arrays.stream(dp[n - 1]).min().getAsInt();
        return res;
    }
}
