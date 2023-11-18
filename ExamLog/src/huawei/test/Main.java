package huawei.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
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
        fields.sort((o1, o2) -> {
            return o1 - o2;
        });
        if (n == m) {
            System.out.println(fields.get(n - 1));
            return;
        }


        int index = 0;
        for (int i = 0; i < m; i++) {
            int k = fields.get(i);
            int aimDay = i + 1;
            for (int j = i + 1; j < m; j++) {
                int tmpArea = fields.get(j);
                aimDay += tmpArea / k  + (tmpArea % k > 0 ? 1 : 0);
            }
            if (aimDay <= n) {
                index = i;
                break;
            }
        }
        for (int j = fields.get(index); j < fields.get(index + 1); j++){
            int aimDay = index + 1;
            for (int i = index + 1; i < m; i++) {
                int tmpArea = fields.get(i);
                aimDay += tmpArea / j  + (tmpArea % j > 0 ? 1 : 0);
            }
            if (aimDay == n) {
                System.out.println(j);
                break;
            }
        }
    }
}
