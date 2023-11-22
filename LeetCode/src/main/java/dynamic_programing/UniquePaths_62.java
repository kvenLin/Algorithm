package dynamic_programing;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 */

public class UniquePaths_62 {
    public int f[][];

    public int uniquePaths(int m, int n) {
        f = new int[m + 1][n + 1];
        return dp2(m, n);
    }

    public int dp(int m, int n) {
        if (m <= 1) {
            return 1;
        }
        if (n <= 1) {
            return 1;
        }
        if (f[m][n] != 0) {
            return f[m][n];
        }
        int res = dp(m - 1, n) + dp(m, n - 1);
        f[m][n] = res;
        return res;
    }

    //第二种解法, 不使用递归的方式
    public int dp2(int m, int n) {
        int[][] f = new int[m][n];
        f[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                } else if (i > 0) {
                    f[i][j] = f[i - 1][j];
                } else if (j > 0) {
                    f[i][j] = f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths_62 ex = new UniquePaths_62();
        int i = ex.uniquePaths(3, 7);
        System.out.println(i);
    }
}
