package huawei;

import java.util.Scanner;

/**
 * 描述
 * N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。
 *
 * 设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为
 *  ，则称这
 * K名同学排成了合唱队形。
 * 通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
 * 例子：
 * 123 124 125 123 121 是一个合唱队形
 * 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
 * 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 *
 * 数据范围：
 * 1≤n≤3000
 *
 * 输入描述：
 * 用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 *
 * 输出描述：
 * 最少需要几位同学出列
 *
 * 示例1
 * 输入：
 * 8
 * 186 186 150 200 160 130 197 200
 * 复制
 * 输出：
 * 4
 * 复制
 * 说明：
 * 由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
 */
public class HJ24 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] stu = new int[n];
        for (int i = 0; i < n; i++) {
            stu[i] = in.nextInt();
        }
        int[] leftDp = new int[n];
        int[] rightDp = new int[n];
        for (int i = 0; i < stu.length; i++) {
            leftDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (stu[i] > stu[j]) {
                    //stu i 左侧满足的递增最大长度
                    leftDp[i] = Math.max(leftDp[i], leftDp[j] + 1);
                }
            }
        }

        for (int i = stu.length - 1; i >= 0; i--) {
            rightDp[i] = 1;
            for (int j = stu.length - 1; j > i; j--) {
                if (stu[i] > stu[j]) {
                    //stu i 右侧满足的递减最大长度
                    rightDp[i] = Math.max(rightDp[i], rightDp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, leftDp[i] + rightDp[i] - 1);
        }
        System.out.println(n - res);
    }
}
