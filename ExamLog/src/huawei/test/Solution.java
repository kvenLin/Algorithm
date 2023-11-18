package huawei.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        if (n < m) {
            System.out.println(-1);
        }
        List<Integer> fields = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            fields.add(in.nextInt());
        }
        if (n == m) {
            System.out.println(fields.get(m - 1));
        }
        fields.sort((o1, o2) -> {
            return o1 - o2;
        });

        int index = 0;
        int minIndex = 0;
        int maxIndex = 0;
        while (true) {
            int aimDay = 0;
            int k = fields.get(index++);
            for (int i = 0; i < fields.size(); i++) {
                int tmpArea = fields.get(i);
                aimDay += tmpArea / k  + (tmpArea % k > 0 ? 1 : 0);
                if (aimDay >= n) {
                    minIndex = index;
                    continue;
                }
            }
            if (aimDay < n) {
                maxIndex = index;
                break;
            }
        }
        for (int i = fields.get(minIndex); i < fields.get(maxIndex); i++) {
            int aimDay = minIndex;
            for (int j = minIndex; j < m; j++) {
                int tmpArea = fields.get(i);
                aimDay += tmpArea / i  + (tmpArea % i > 0 ? 1 : 0);
            }
            if (aimDay == n) {
                System.out.println(i);
                break;
            }
        }

    }
}
