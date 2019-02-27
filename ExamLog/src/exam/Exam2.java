package exam;

import java.util.Scanner;

/**
 * @Author: clf
 * @Date: 19-2-20
 * @Description:
 * 牛牛每天必须吃雪糕: 即至少1份
 * 有 :
 * a : 1盒 1份
 * b : 1盒 2份
 * c : 1盒 3份
 *
 * 最多一天吃 6份
 *
 */
public class Exam2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = 0;
        if (in.hasNextInt()){
            row = in.nextInt();
        }
        int data[][] = null;
        if (row > 0){
            data = new int[row][4];
        }
        int k = 0;
        while (in.hasNextInt()) {
            //day num
            data[k][0] = in.nextInt();
            //a num
            data[k][1] = in.nextInt();
            //b num
            data[k][2] = in.nextInt();
            //c num
            data[k][3] = in.nextInt();
            k++;
        }
        for (int i = 0; i < data.length; i++) {
            int days = data[i][0];
            int a = data[i][1];
            int b = data[i][2];
            int c = data[i][3];
            while (days > 0 && (a != 0 || b != 0 || c != 0)){
                 if (a > 0){
                     days --;
                     a --;
                 }else if (b > 0){
                     days --;
                     b --;
                 }else {
                     days --;
                     c --;
                 }
            }
            if (days == 0){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

    }
}
