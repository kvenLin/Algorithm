/**
 * @Author: clf
 * @Date: 19-3-6
 * @Description:
 * 希尔排序
 * 思路:先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序,待整个序列
 * 中的记录“基本有序”时,再对全体记录进行依次直接插入排序。
 * 注： gap 可以理解为步长
 */
public class ShellSort {
    public static void main(String[] args) {
        int a[] = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};//a.length = 10
        sort(a);
        printArr(a);
    }

    public static void sort(int arr[]){
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i ++){
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]){
                    //插入排序采用交换法，即每次只比较两个元素，满足就交换
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                    j = j - gap;
                }
            }
        }
    }

    /**
     * 分析：
     * 第一次： 初始gap = arr.length / 2 = 5，即当前的元素被分为5组
     * (8, 3) (9, 5) (1, 4) (7, 6) (2, 0)
     * 排序后： 3, 5, 1, 6, 0, 8, 9, 4, 7, 2
     * 第二次： gap = gap / 2 = 2，即当前元素被分为2组
     * (3, 1, 0, 9, 7) (5, 6, 8, 4, 2)
     * 排序后： 0, 2, 1, 4, 3, 5, 7, 6, 9, 8
     * 第三次： gap = gap / 2 = 1，即当前元素被分为1组
     * 此时相当于直接采用插入排序。
     * 排序后： 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
     */

    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
