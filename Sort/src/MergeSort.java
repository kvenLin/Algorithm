/**
 * @Author: clf
 * @Date: 19-3-16
 * @Description:
 * 归并排序
 * 思路：
 * 和快速排序差不多，也是采用分而治之的思想
 * 简单将就是，每次都将一个序列差分成两个子序列，
 * 而子序列又差分成两个子序列，依次递归。
 * 等子序列排序后再进行合并排序。
 */
public class MergeSort {
    public static void main(String[] args) {
        int a[] = new int[]{5, 2, 56, 8, 15, 3, 4, 1, 0};
        sort(a, 0, a.length - 1);
        printArr(a);
    }
    //两路归并算法，两个排好序的子序列合并为一个子序列
    public static void merge(int arr[], int left, int mid, int right){
        int []tmp = new int[arr.length];//辅助数组
        int p1=left, p2=mid+1, k=left;//p1、p2是检测指针，k是存放指针

        while(p1 <= mid && p2 <= right){
            if(arr[p1] <= arr[p2])
                tmp[k++] = arr[p1++];
            else
                tmp[k++] = arr[p2++];
        }

        while(p1 <= mid) tmp[k++] = arr[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2 <= right) tmp[k++] = arr [p2++];//同上

        //复制回原素组
        for (int i = left; i <= right; i++)
            arr[i] = tmp[i];
    }
    public static void sort(int arr[], int start, int end){
        if (start < end){//当子序列中只有一个元素时结束递归
            int mid = (start + end) / 2;//划分成两个子序列
            sort(arr, start, mid);//对左侧的子序列进行归并排序
            sort(arr, mid + 1, end);//对右侧的子序列进行归并排序
            merge(arr, start, mid, end);//合并
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
