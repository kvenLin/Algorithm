/**
 * @Author: clf
 * @Date: 19-3-6
 * @Description:
 * 二分查找
 * 思路:
 * 1.先标记最高位置(high)和最低位置(low)
 * 2.获取中间位置 mid = (low + high) / 2
 * 3.比较目标元素和 arr[mid] 的大小
 * 4.小于则进行前半部分中查找, 大于则在后半部分查找
 */
public class BiSearch {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 5, 6, 9, 10, 12, 13};
        System.out.println(search(a, 10));
    }

    /**
     * 获取某元素值在数组中的位置
     * @param arr
     * @return
     */
    public static int search(int[] arr, int aim){
        int high = arr.length;
        int low = 0;
        while (low <= high){
            int mid = (high + low) / 2;
            if (arr[mid] == aim){
                //返回所在位置(即第几个元素)
                return mid + 1;
            }else if (arr[mid] < aim){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
