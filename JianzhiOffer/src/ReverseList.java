import java.util.ArrayList;

/**
 * @Author: clf
 * @Date: 18-11-28
 * @Description:
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode p = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (p != null){
            list.add(p.val);
            p = p.next;
        }
        ListNode dummyHead = new ListNode(0);
        p = dummyHead;
        for (int i = list.size() - 1; i >= 0; i --){
            p.next = new ListNode(list.get(i));
            p = p.next;

        }
        return dummyHead.next;
    }
}
