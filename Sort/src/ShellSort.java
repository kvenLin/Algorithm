/**
 * @Author: clf
 * @Date: 19-3-6
 * @Description:
 * 希尔排序
 * 基本思想:先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序,待整个序列
 * 中的记录“基本有序”时,再对全体记录进行依次直接插入排序。
 */
public class ShellSort {
    public static void main(String[] args) {
        int a[] = new int[]{5, 2, 56, 8, 15, 3, 4, 1, 0};
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
                    //插入排序采用交换法
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;
                    j = j - gap;
                }
            }
        }
    }

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
