package huawei.test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        int [][] nodes = new int [size][];
        for (int i = 0; i < size; i++) {
            nodes [i] = parseOneLine(in.nextLine());
        }
        int[] xy = parseOneLine(in.nextLine());
        String result = doQuery(nodes, xy [0], xy [1]);
        System.out.println(result);
    }

    private static int[] parseOneLine(String text) {
        ByteArrayInputStream stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        Scanner in = new Scanner(stream);
        List<Integer> list = new ArrayList<>();
        while (in.hasNext()) {
            list.add(in.nextInt());
        }
        return list.stream().mapToInt(value -> value).toArray();
    }


    private static String doQuery(int [][] nodes, int x, int y) {
        if (x <0 || y < 0) {
            return "{}";
        }
        int deep = 0;
        int[] root = nodes[0];
        if (x == 0 && y == 0) {
            return "{" + root[0] + "}";
        }
        for (int i = 0; i < x; i++) {

        }
        return "";
    }

//    private static int trease(int[][] nodes, int startX, int startY, int x, int y, int index) {
//        int v = nodes[startX][startY];
//        int[] node = nodes[startX];
//
//    }



}
