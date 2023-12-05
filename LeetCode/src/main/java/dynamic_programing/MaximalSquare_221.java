package dynamic_programing;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 输入：matrix =
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出：4
 */
public class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = Integer.valueOf(matrix[i][0] + "");
            max = Math.max(dp[i][0], max);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = Integer.valueOf(matrix[0][j] + "");
            max = Math.max(dp[0][j], max);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char data = matrix[i][j];
                if (data == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]),
                        dp[i][j - 1]) + Integer.valueOf(data + "");
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        MaximalSquare_221 maximalSquare_221 = new MaximalSquare_221();
        //[["1","0","1","1","0","1"],
        // ["1","1","1","1","1","1"],
        // ["0","1","1","0","1","1"],
        // ["1","1","1","0","1","0"],
        // ["0","1","1","1","1","1"],
        // ["1","1","0","1","1","1"]]
        char[][] matrix = new char[][]{
                {'1','0','1','1','0','1'},
                {'1','1','1','1','1','1'},
                {'0','1','1','0','1','1'},
                {'1','1','1','0','1','0'},
                {'0','1','1','1','1','1'},
                {'1','1','0','1','1','1'}
        };
        System.out.println(maximalSquare_221.maximalSquare(matrix));
    }

}
