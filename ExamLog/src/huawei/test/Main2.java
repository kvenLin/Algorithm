package huawei.test;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int days = in.nextInt();
        int[] itemStore = new int[number];
        for (int i = 0; i < number; i++) {
            itemStore[i] = in.nextInt();
        }
        int[][] itemPrice = new int[number][days];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < days; j++) {
                itemPrice[i][j] = in.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0; i < number; i++) {
            int[] dayPrices = itemPrice[i];
            sum += getMaxValue(dayPrices, itemStore[i]);
        }
        System.out.println(sum);
    }

    private static int getMaxValue(int[] dayPrices, int num) {
        int sum = 0;
        for (int i = 0; i < dayPrices.length; i++) {
            int k = i + 1;
            if (k < dayPrices.length) {
                if (dayPrices[k] > dayPrices[i]) {
                    sum += num * (dayPrices[k] - dayPrices[i]);
                }
            }
        }
        return sum;
    }
}
