import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 */
public class CloseThreeNumSum {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        int abs = Math.abs(target - res);
        for (int i = 0; i < nums.length; i++) {
            //跳过重复值
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int calRes = nums[i] + nums[l] + nums[r];
                int tmpabs = Math.abs(calRes - target);
                if (tmpabs < abs) {
                    res = calRes;
                    abs = tmpabs;
                }
                if (calRes < target) {
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        nums = Arrays.stream(nums).sorted().toArray();
        System.out.println(Arrays.toString(nums));
    }
}
