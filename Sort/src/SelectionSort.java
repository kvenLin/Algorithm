/**
 * @Author: clf
 * @Date: 19-3-16
 * @Description:
 * 选择排序：
 * 思路：
 * 遍历一个含有n个元素的数组，
 * 每一次从当前位置进行向后遍历，
 * 找到最小的元素与当前位置的元素进行交换
 */
public class SelectionSort {

    public static void main(String[] args) {
        int a[] = new int[]{3, 5, 1, 2, 4};
        sort(a);
        printArr(a);
    }

    public static void sort(int[] arr){
        //选择排序的优化
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int min = i;//将但前的坐标的元素当作最小的值
            for(int j = min + 1; j < arr.length; j++){//遍历该坐标后的元素
                if(arr[j] < arr[min]){//判断此时遍历的元素是否小于当前记录的最小值
                    min = j; //小于，则更新最小元素的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != min){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
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
