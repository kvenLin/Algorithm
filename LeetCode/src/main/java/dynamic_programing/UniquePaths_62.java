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
        return dp(m, n);
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

    public static void main(String[] args) {
        UniquePaths_62 ex = new UniquePaths_62();
        int i = ex.uniquePaths(7, 3);
        System.out.println(i);
    }
}
