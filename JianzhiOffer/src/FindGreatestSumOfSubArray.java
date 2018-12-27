/**
 * @Author: clf
 * @Date: 18-12-27
 * @Description:
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 *
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {

    /**
     * 思路:
     * 这实际上是一个逐步比较的过程，假设累加进行到某一步，
     * 继续累加下一个数的时候发现和变小了，就应该重新计算当前累加的和，
     * 这实际上就是一个重新赋值的过程。如果累加之后发现变大了，
     * 这当然是我们想要的，自然就继续累加了。
     * 累加之后再判断是否大于原来的最大值，如果不是的话，
     * 就重新赋值最大值为当前累加的和（因为它更大）。
     *
     * temp如果小于0，则temp为当前数；
     * 否则temp等于temp加上当前数；
     * 然后比较sum和temp的大小，sum等于大的那个。
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0){
            return 0;
        }
        int temp = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            //temp变为小于0的数,表示之前的累加小于0,重新开始累加计算
            if (temp < 0){
                temp = array[i];
            }
            temp += array[i];//判断累加赋值给temp
            sum = Math.max(sum,temp);//判断最大累加sum和当前累加temp大小
        }
        return sum;
    }
}
