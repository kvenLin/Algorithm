import java.util.ArrayList;

/**
 * @Author: clf
 * @Date: 18-12-28
 * @Description:
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution {
    /**
     * 思路2：第一个丑数是1，第二个是2
     *
     * 第几个        1   2     3       4      5             6         7         8                 9   ..........
     *
     * 数值         1 2(1*2) 3(1*3) 4（2*2） 5 (1*5)       6（3*2）   8（4*2）   9（3*3）         10（5*2）.........
     *
     * 可见1以后的丑数都是前面的丑数乘以2、3或者5.
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0){
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int p1 = 0,p2 = 0,p3 = 0;//相当于3个计数器,用来记录各个质因子走到的索引位置
        while (list.size() < index){
            int n1 = list.get(p1) * 2;
            int n2 = list.get(p2) * 3;
            int n3 = list.get(p3) * 5;
            int min = Math.min(n1, Math.min(n2, n3));
            list.add(min);//添加最小的丑数
            //进行移动索引,即将当前得到最小的丑的下一倍丑数数和另外两个数进行比较
            if (min == n1){
                p1 ++;
            }
            if (min == n2){
                p2 ++;
            }
            if (min == n3){
                p3 ++;
            }
        }
        return list.get(list.size() - 1);
    }
}
