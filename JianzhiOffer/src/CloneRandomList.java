/**
 * @Author: clf
 * @Date: 18-12-10
 * @Description:
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CloneRandomList {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead){
        CloneNodes(pHead);
        ConnectRandomNodes(pHead);
        return ReConnectNodes(pHead);
    }

    // 第一步：根据原始链表的每个结点N创建对应的结点N'
    private void CloneNodes(RandomListNode pHead){
        RandomListNode node = pHead;
        while (node != null){
            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNode.next = node.next;
            cloneNode.random = null;

            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    // 第二步：设置复制出来结点的random.假设原始结点的随机指向S，复制出来结点的random指向S后一个
    private void ConnectRandomNodes(RandomListNode pHead){
        RandomListNode node = pHead;
        while (node != null){
            RandomListNode clone = node.next;
            if (node.random != null){
                clone.random = node.random.next;
            }
            node = clone.next;
        }
    }

    // 第三步：把这个长链表拆分成两个链表，奇数位置连接起来就是原始链表，偶数结点连接起来就是复制结点
    private RandomListNode ReConnectNodes(RandomListNode pHead){
        RandomListNode node = pHead;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;

        // 设置第一个节点
        if (node != null){
            cloneHead = node.next;
            cloneNode = node.next;
            node.next = cloneNode.next;
            node = node.next;
        }

        while (node != null){
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }

}
