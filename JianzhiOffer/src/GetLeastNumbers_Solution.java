import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: clf
 * @Date: 18-12-23
 * @Description:
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length){
            return list;
        }
        Arrays.sort(input);

        for (int i = 0; i < input.length; i++) {
            list.add(input[i]);
            if (i == k - 1){
                return list;
            }
        }
        return list;
    }
}
