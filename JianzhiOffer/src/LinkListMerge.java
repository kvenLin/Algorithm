/**
 * @Author: clf
 * @Date: 18-12-1
 * @Description:
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class LinkListMerge {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路：递归思想，传入链表的头节点后对节点的值进行比较，
     * 若list1.val <= list2.val 则将list2.next和list节点进行比较，
     * 若list2.val > list2.val 则将list2和list.next节点进行比较
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 != null){
            return list2;
        }else if (list1 != null && list2 == null){
            return list1;
        }else if (list1 == null && list2 == null){
            return null;
        }else {
            if (list1.val <= list2.val){
                list1.next = Merge(list1.next, list2);
                return list1;
            }else {
                list2.next = Merge(list1, list2.next);
                return list2;
            }
        }
    }

}
