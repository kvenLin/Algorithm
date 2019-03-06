/**
 * @Author: clf
 * @Date: 19-3-6
 * @Description:
 * 插入排序:
 * 思路: 将需要插入的值与前面的有序元素进行比较进行插入
 */
public class InsertionSort {
    public static void main(String[] args) {
        int a[] = new int[]{5, 2, 56, 8, 15, 3, 4, 1, 0};
        sort(a);
        printArr(a);
    }

    public static void sort(int arr[]){
        //对n个数进行插入排序只需要进行 n - 1 次
        for (int i = 1; i < arr.length; i++) {
            //插入的数
            int insertValue = arr[i];
            //准备和前一个数进行比较
            int index = i - 1;
            //如果index位置的元素比要插入的元素大,则需要将其后移
            while (index >= 0 && insertValue < arr[index]){
                //将arr[index]向后移动
                arr[index + 1] = arr[index];
                //将index向前移动
                index--;
            }
            //while跳出,即index位置的数比插入的元素小,index + 1进行插入
            arr[index + 1] = insertValue;
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
