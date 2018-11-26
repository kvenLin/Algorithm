import java.util.HashSet;

/**
 * @Author: clf
 * @Date: 18-11-26
 * @Description:
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，
 * 输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class ArrayFindTarget {
    public boolean Find(int target, int [][] array) {
        HashSet hashSet = new HashSet();
        for (int j=0;j<array.length;j++){
            for (int i=0;i<array[j].length;i++){
                hashSet.add(array[j][i]);
            }
        }
        Integer size = hashSet.size();
        hashSet.add(target);
        if (hashSet.size()==size){
            return true;
        }
        return false;
    }
}
