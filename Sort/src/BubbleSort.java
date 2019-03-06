/**
 * @Author: clf
 * @Date: 19-3-6
 * @Description:
 * 冒泡排序
 * 思路:
 * 设数组有n个元素
 * 1.外层循环表示遍历n次
 * 2.内层循环每次遍历都比上一次遍历的数要少一个,j = 0 ---> arr.length - i - 1
 * 3.根据升序后降序对元素进行交换
 */
public class BubbleSort {
    public static void main(String[] args) {
        int a[] = new int[]{5, 2, 56, 8, 15, 3, 4, 1, 0};
        sort(a);
        printArr(a);
    }

    public static void sort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                 if (arr[j] > arr[j + 1]){
                     int temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
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
