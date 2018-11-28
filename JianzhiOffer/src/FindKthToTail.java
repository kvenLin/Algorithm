import java.util.HashMap;

/**
 * @Author: clf
 * @Date: 18-11-27
 * @Description:
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null){
            return null;
        }
        HashMap<Integer,ListNode> map = new HashMap<>();
        int len = 0;
        ListNode p = head;
        while (p != null){
            map.put(len,p);
            len ++;
            p = p.next;
        }
        if (len - k < 0){
            return null;
        }else {
            return map.get(len - k);
        }

    }

    public ListNode convert(int[] array){
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < array.length; i++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        FindKthToTail kth = new FindKthToTail();
        int[] arrry = {1, 2, 3};
        ListNode head = kth.convert(arrry);
        System.out.println(kth.FindKthToTail(head,1).val);
    }
}
