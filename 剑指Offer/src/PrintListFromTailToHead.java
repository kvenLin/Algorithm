import java.util.ArrayList;

/**
 * @Author: clf
 * @Date: 18-11-26
 * @Description:
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {
    private class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }

    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList arrayList = new ArrayList();
        ListNode p = listNode;
        while(p != null){
            arrayList.add(p.val);
            p = p.next;
        }
        ArrayList retList = new ArrayList();
        for(int j = arrayList.size() - 1; j >= 0; j --){
            retList.add(arrayList.get(j));
        }
        return retList;
    }
}
