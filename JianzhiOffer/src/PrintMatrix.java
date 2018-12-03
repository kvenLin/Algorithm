import java.util.ArrayList;

/**
 * @Author: clf
 * @Date: 18-12-2
 * @Description:
 * 题目描述
 * 输入一个矩阵，
 * 按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        //判断是否为空矩阵
        if (matrix.length ==0){
            return null;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int endRow = 1;
        int endCol = 0;
        int x = 0, y = 0;
        int k = 1;//从四个方向遍历,1向右,2向下,3向左,4向上

        ArrayList<Integer> list = new ArrayList<>();

        //判断是否将所有元素添加到list中，添加完成就结束遍历
        while (list.size() != matrix.length * matrix[0].length){
            list.add(matrix[y][x]);
            //向右遍历
            if (k == 1){
                //判断是否到达右边界
                if (x + 1 == cols){
                    //向下移动
                    y ++;
                    //改变遍历方向
                    k ++;
                    continue;
                }else {
                    //继续遍历
                    x ++;
                }
            }
            //向下遍历
            if (k == 2){
                //判断是否到达下边界
                if (y + 1 == rows){
                    //向左移动
                    x --;
                    //遍历行数-1,向内遍历
                    rows --;
                    //改变遍历方向
                    k ++;
                    continue;
                }else {
                    //继续遍历
                    y ++;
                }
            }
            //向左遍历
            if (k == 3){
                //判断是否到达左边界
                if (x == endCol) {
                    //向上移动
                    y --;
                    //右边界-1
                    cols --;
                    //左边界+1
                    endCol ++;
                    k ++;
                    continue;
                }else {
                    x --;
                }
            }
            //向上遍历
            if (k == 4){
                //判断是否到达上边界
                if (y == endRow){
                    //向有移动
                    x ++;
                    //上边界+1
                    endRow ++;
                    //向右进行遍历
                    k = 1;
                    continue;
                }else {
                    y --;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7, 8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list = new PrintMatrix().printMatrix(matrix);
        System.out.println(list.toString());
    }
}
