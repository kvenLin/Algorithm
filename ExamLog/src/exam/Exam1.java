package exam;

import java.util.Scanner;

/**
 * @Author: clf
 * @Date: 19-2-20
 * @Description:
 * 牛牛必须每天吃 1个 水果 & 每天交付 x元 房屋租金
 *
 * 牛牛拥有f个水果和d元钱
 *
 * 每个水果售卖p元
 *
 * 求最多能够独立生活时间?
 */
public class Exam1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = 0, f = 0, d = 0, p = 0;
        //注意while处理多个case
        while (in.hasNextInt()) {
            x = in.nextInt();
            f = in.nextInt();
            d = in.nextInt();
            p = in.nextInt();
        }
        if (x < 1 || f < 1 || d < 1 || p < 1){
            throw new IllegalArgumentException();
        }

        int dayNums = 0;
        while (d >= p + x){
            d = d - x;
            if (f > 0){
                f--;
            }else {
                d = d - p;
            }
            dayNums ++;
        }
        if (f > 0){
            while (d >= x){
                f--;
                d = d - x;
                dayNums ++;
            }
        }
        System.out.println(dayNums);
    }
}
