package dynamic_programing;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 *
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *
 * 思路:
 * 我来理解一下为什么可以转换为打家劫舍问题： 把原数组转换成一个新数组，
 * 新数组的下标i所对应的值为原数组的元素i在原数组中数字的总和，比如原数组[2, 2, 3, 3, 3, 4],
 * 转换为新数组就是[0, 0, 4, 9, 4]。在新数组中，下标0和1表示在原数组中没有0和1这两个数，
 * 新数组下标2的值是4，表示在原数组中，所有2的总和是4。转换的目的就是可以从新数组中得到删除nums[i]而得到的点数，
 * 也就是可以打劫的金额。因为删除nums[i]后，还要删除nums[i] + 1和nums[i] - 1，
 * 在新数组中就意味着不能取相邻的元素，不能取相邻的元素和打家劫舍也是一样的。
 * 接下来就可以使用打家劫舍的方式解答了
 */
public class DeleteAndEarn_740 {
    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num]++;
        }
        int[] dp = new int[sum.length];
        dp[0] = sum[0];
        dp[1] = sum[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * sum[i]);
        }
        return dp[dp.length - 1];
    }

}
