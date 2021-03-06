# Algorithm
## 相关思路记录
### Fibonacci
* 对于相关Fibonacci的题,先找出规律再进行表达式的总结.
* 相关题目参考:
    * [Fibonacci](https://github.com/kvenLin/Algorithm/blob/master/JianzhiOffer/src/Fibonacci.java)
    * [跳台阶](https://github.com/kvenLin/Algorithm/blob/master/JianzhiOffer/src/JumpFloor.java)
    * [变态跳台阶](https://github.com/kvenLin/Algorithm/blob/master/JianzhiOffer/src/JumpFloorII.java)
    * [矩形覆盖问题](https://github.com/kvenLin/Algorithm/blob/master/JianzhiOffer/src/RectCover.java)
    
### 字符串的排列
* [Permutation](https://github.com/kvenLin/Algorithm/blob/master/JianzhiOffer/src/Permutation.java)
* 思路:
    * 把整个字符串视为第一个字符和后来的字符的字符的组合
    * 每次确定一个元素,和后面的元素一次兑换
* ![图示流程](https://pic4.zhimg.com/80/v2-48fce50383aa798b64fce457a49af897_hd.jpg)
## 巧解
* [找出数组中超过数组长度的一般的元素](https://github.com/kvenLin/Algorithm/blob/master/JianzhiOffer/src/MoreThanHalfNum_Solution.java)
* 思路:
    * 先对数组进行一次从小到大排序
    * 若超过一半,按顺序排列数组的中间值肯定就是这个数,将arr[length/2]这个数字提出来做比较
    * 遍历一次数组同时进行计数,判断arr[length/2]这个数是否连续超过了数组的一半的长度